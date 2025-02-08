package org.example.utils;

import org.example.dto.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogCsvParser {

    /**
     * Parses log entries from a given file.
     * @param filename The name of the file containing logs.
     * @return A list of parsed log entries.
     * @throws IOException If there are issues reading the file.
     */
    public static List<LogEntry> parseLogFile(String filename) throws IOException {
        List<LogEntry> logEntries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split by comma assuming format HH:MM:SS,description,message_type,PID
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                LogEntry entry = new LogEntry(parts[0], parts[1], parts[2], parts[3]);
                logEntries.add(entry);
            }
        }
        return logEntries;
    }
}