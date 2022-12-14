package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Log {


    public static void log(String message) {
//        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();

        String auditPath = "logs/search.log";
        File logFile = new File(auditPath);
        // Using a FileOutputStream with true passed into the constructor opens the file for append.
        try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
//            log.println(today+" "+time+" "+message);
            log.println(dtf.format(now)+" "+message);
        } catch (LogException | FileNotFoundException e) {
            System.out.println("*** Unable to open log file: " + logFile.getAbsolutePath());
        }

    }
}
