package org.example.dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.example.Monitor.HH_MM_SS;

public class LogEntry {

    private final LocalTime timestamp;
    private final String description;
    private final String messageType; // START or END
    private final String pid;

    public LogEntry(String timestamp,
                    String description,
                    String messageType,
                    String pid) {
        this.timestamp = LocalTime.parse(timestamp, DateTimeFormatter.ofPattern(HH_MM_SS));
        this.description = description;
        this.messageType = messageType;
        this.pid = pid;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStart() {
        return "START".equalsIgnoreCase(messageType);
    }

    public boolean isEnd() {
        return "END".equalsIgnoreCase(messageType);
    }

    public String getPid() {
        return pid;
    }
}