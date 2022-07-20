package com.androidos.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private LocalTime time;
    private String TIMEPATTERN = "HH:mm:ss";
    
    public Time() {
    }

    public String getFormatedTime() {
        time = LocalTime.now();
        return time.format(DateTimeFormatter.ofPattern(TIMEPATTERN));
    }
}
