package com.androidos.timer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TimerTest {
    private Timer timer;
    @Before 
    public void setup() {
        timer = new Timer();
    }
    @Test
    public void testDecreaseTimeBy10MilisecondsAndReturn() {
        timer.setTime(1);
        timer.startTimer();
        for (int i = 0; i < 100 * 50; i++) {
            timer.decreaseTimeBy10MilisecondsAndReturn();
        }
        assertEquals("00:10:00", timer.getTimerInFormate());
    }

    @Test
    public void testSetTime() {
        timer.setTime(10);
        assertEquals("10:00:00", timer.getTimerInFormate());
    }

    @Test
    public void testSetTimeAfterStart() {
        timer.setTime(20);
        timer.startTimer();
        timer.setTime(11);
        assertEquals("20:00:00", timer.getTimerInFormate());
    }

    @Test
    public void testStartTimer() {
        timer.startTimer();
       assertEquals("00:00:00", timer.decreaseTimeBy10MilisecondsAndReturn());
    }
}
