package org.example;

import org.example.dto.LogDto;
import org.example.dto.LogEntry;
import org.example.exceptions.CsvWriteException;
import org.example.service.JobMonitor;
import org.example.utils.LogCsvParser;
import org.example.utils.LogCsvWriter;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        // Parse command line arguments for input and output filenames
        if (args.length < 2) {
            System.err.println("Usage: <input_file_path> <output_file_path>");
            System.exit(1);
        }

        Monitor.monitorApp(args[0], args[1]);
    }

}