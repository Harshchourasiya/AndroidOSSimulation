package com.androidos.stopwatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WatchTest {
    Watch watch = new Watch();
    @Test
    public void testGetStopWatchFormatedInitial() {
        assertEquals("00:00:00", watch.getStopWatchFormated()); 
    }

    @Test
    public void testIncreaseTimeBy10MiliSecond() {
        for (int i = 0; i < 100 * 60 * 10 ; i++) {
            watch.increaseTimeBy10MiliSecond();
        }
        assertEquals("10:00:00", watch.getStopWatchFormated()); 

    }

    @Test
    public void testReset() {
        watch.reset();
        assertEquals("00:00:00", watch.getStopWatchFormated());
    }

    @Test
    public void testStopAndStartSwitch() {
        watch.stopAndStartSwitch();
        String time = watch.getStopWatchFormated();
        for (int i = 0; i < 10000; i++) {
            assertEquals(time, watch.getStopWatchFormated());
        } 
    }
}
