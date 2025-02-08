package org.example.utils;

import org.example.dto.LogDto;
import org.example.exceptions.CsvWriteException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class LogCsvWriter {

    public static void writeOutputToCsv(String filePath, String[] headers, List<LogDto> data) throws CsvWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write headers
            writer.write(String.join(",", headers));
            writer.newLine();

            // Write each row in the data
            for (LogDto row : data) {
                writer.write(row.pid() + "," + row.duration() + "," + row.description());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new CsvWriteException(e.getMessage(), e);
        }
    }
}