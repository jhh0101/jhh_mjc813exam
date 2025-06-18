package com.mjc813.thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public void log(Object o){
        LocalTime now = LocalTime.now();
        String format = now.format(formatter);

        System.out.printf("%s [%9s] %s\n", format, Thread.currentThread().getName(), o);
    }
}
