package com.androidos.timer;

import com.androidos.helper.TimeFormater;

public class Timer {
    private int minutes, seconds, miliSecondsPer10;
    private boolean isStart;
    private TimeFormater formater;
    
    public Timer() {
        isStart = false;
        formater = new TimeFormater();
        minutes = 0;
        seconds = 0;
        miliSecondsPer10 = 0;
    }

    public void setTime(int minutes) {
        if (isStart) return;

        this.minutes = minutes;
        seconds = 0;
        miliSecondsPer10 = 0;
    }

    public void reset() {
        minutes = 0;
        seconds = 0;
        miliSecondsPer10 = 0;
        isStart = false;
    }

    public String decreaseTimeBy10MilisecondsAndReturn() {
        if (!isStart) return getTimerInFormate();
        correctTime();
        return getTimerInFormate();
    }

    private void correctTime() {
        miliSecondsPer10--;
        if (miliSecondsPer10 == -1) decreaseSecond();

        if (seconds == -1) decreaseMinute();
    }

    private void decreaseSecond() {
        seconds--;
        miliSecondsPer10 = 99;
    }

    private void decreaseMinute() {
        minutes--;
        seconds = 59;
    }

    public void startTimer() {
        if (minutes == 0 && seconds == 0 && miliSecondsPer10 == 0) return ;
        isStart = true;
    }

    public String getTimerInFormate() {
        return formater.getTimeFormated(minutes, seconds, miliSecondsPer10);
    }

    public boolean isTimerEnd() {
        if (!isStart) return true;

        if (isStart && 
        formater.getTimeFormated(0,0, 0).equals(getTimerInFormate())) return true;

        return false;
    }

}
