Java Logging Monitoring Application

Description:

A Java application that monitors job durations based on logs provided in a .csv format and generates warnings/errors according to specified thresholds.

Created a log monitoring application that reads from a CSV input file, processes log entries to calculate job durations, and writes results back to a CSV output file

1. Reading from an input CSV file.

2. Processing the logs.

3. Generating output with warnings/errors based on specified thresholds.

4. Writing the results to an output CSV file.

5. Unit tests using JUnit.


Requirements:

Java SDK installed [version >=11]

Maven installed [optional]


How To Run:

mvn clean package && mvn exec：exec -Dexec.mainClass=com.example.LogMonitoring.App -Dexec.args="path/to/input/logs.csv path/to/output/summary.csv"

or configure IDE settings accordingly.
