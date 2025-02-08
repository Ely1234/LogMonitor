package org.example.service;

import org.example.dto.LogDto;
import org.example.dto.LogEntry;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobMonitor {

    /**
     * Monitors jobs based on parsed logs and generates alerts based on their duration.
     */
    public List<LogDto> monitorJobs(List<LogEntry> entries, int warningThreshold, int errorThreshold) {
        List<LogDto> output = new ArrayList<>();
        HashMap<String, LocalTime> startTimes = new HashMap<>();

        for (LogEntry entry : entries) {
            if (entry.isStart()) {
                startTimes.put(entry.getPid(), entry.getTimestamp());
            } else if (entry.isEnd()) {
                LocalTime startTime = startTimes.remove(entry.getPid());

                if (startTime != null) {
                    Duration duration = Duration.between(startTime, entry.getTimestamp());

                    long seconds = duration.toSeconds();

                    String msg = entry.getDescription();
                    if (seconds > errorThreshold) {
                        msg = "ERROR: Job PID " + entry.getPid() + " took longer than 10 minutes.";
                    } else if (seconds > warningThreshold) {
                        msg = "WARNING: Job PID " + entry.getPid() + " took longer than 5 minutes.";
                    } else {
                        msg = "INFO: Job PID " + entry.getPid() + " " + entry.getDescription();
                    }

                    output.add(new LogDto(entry.getPid(), seconds, msg));
                    System.out.println(msg);
                }
            }
        }

        return output;
    }
}
