package org.example;

import org.example.dto.LogDto;
import org.example.dto.LogEntry;
import org.example.exceptions.CsvWriteException;
import org.example.service.JobMonitor;
import org.example.utils.LogCsvParser;
import org.example.utils.LogCsvWriter;

import java.io.IOException;
import java.util.List;

public class Monitor {

    public static final String HH_MM_SS = "HH:mm:ss";

    static final int TIME_LIMIT_WARNING_SECONDS = 300;//5 minutes in seconds
    static final int TIME_LIMIT_ERROR_SECONDS = 600;//10 minutes in seconds

    static void monitorApp(String inputFile, String outputFile) throws IOException, CsvWriteException {
        // Initialize objects
        List<LogEntry> logEntries = LogCsvParser.parseLogFile(inputFile);

        // Monitor data
        JobMonitor monitor = new JobMonitor();
        List<LogDto> output = monitor.monitorJobs(logEntries, TIME_LIMIT_WARNING_SECONDS, TIME_LIMIT_ERROR_SECONDS);

        // View output
        String[] headers = {"PID", "Duration(seconds)", "Message"};
        LogCsvWriter.writeOutputToCsv(outputFile, headers, output);
    }
}
