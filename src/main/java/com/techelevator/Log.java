package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Log {

    public static void log(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String auditPath = "logs/vending.log";
        File logFile = new File(auditPath);
        // Using a FileOutputStream with true passed into the constructor opens the file for append.
        try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
            log.println(dtf.format(now)+" "+message);

        } catch (LogException | FileNotFoundException e) {
            System.out.println("*** Unable to open log file: " + logFile.getAbsolutePath());
        }
    }
}
