package com.androidos.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private LocalTime time;
    private String TIMEPATTERN = "HH:mm:ss";
    
    public Time() {
        time = LocalTime.now();
    }

    public String getFormatedTime() {
        return time.format(DateTimeFormatter.ofPattern(TIMEPATTERN));
    }
}
