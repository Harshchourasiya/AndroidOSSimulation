package com.androidos.stopwatch;

import com.androidos.helper.TimeFormater;

public class Watch {
    private int minutes, seconds, miliSecondsPre10;
    private boolean isStop; 
    private TimeFormater formater;
    public Watch() {
        minutes = 0;
        seconds = 0;
        miliSecondsPre10 = 0;
        isStop = false;
        formater = new TimeFormater();
    }

    public String increaseTimeBy10MiliSecondsAndReturn() {
        if (isStop) return getStopWatchFormated();

        miliSecondsPre10++;
        correctTime();
        return getStopWatchFormated();
    }

    private void correctTime() {
        if (miliSecondsPre10 == 100) increaseSecond();
        
        if (seconds == 60) increaseMinute();
    }

    private void increaseSecond() {
        miliSecondsPre10 = 0;
        seconds++;
    }

    private void increaseMinute() {
        seconds = 0;
        minutes++;
    }

    public String getStopWatchFormated() {
        return formater.getTimeFormated(minutes, seconds, miliSecondsPre10);
    }

    public void reset() {
        miliSecondsPre10 = 0;
        seconds = 0;
        minutes = 0;
    }

    public void stopAndStartSwitch() {
        isStop = !isStop;
    }

}
