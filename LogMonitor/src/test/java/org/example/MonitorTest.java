package org.example;

import org.example.exceptions.CsvWriteException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MonitorTest {

    @Test
    public void testMonitoringJob() throws IOException, CsvWriteException {

        Monitor.monitorApp("src/test/resources/input.csv", "src/test/resources/output.csv");

        String[] expected = {
                "PID,Duration(seconds),Message",
                "12345671,660,ERROR: Job PID 12345671 took longer than 10 minutes.",
                "12345672,360,WARNING: Job PID 12345672 took longer than 5 minutes.",
                "12345673,240,INFO: Job PID 12345673 Long running task"};

        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/output.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                assertEquals(expected[i++], line.trim());
            }
        }
    }
}