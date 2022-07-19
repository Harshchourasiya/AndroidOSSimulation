package com.androidos.stopwatch;

public class Watch {
    private int minutes, seconds, miliSecondsPre10;
    private boolean isStop; 

    public Watch() {
        minutes = 0;
        seconds = 0;
        miliSecondsPre10 = 0;
        isStop = false;
    }

    public String increaseTimeBy10MiliSecond() {
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
        String miliSecondString = String.valueOf(miliSecondsPre10);
        String secondString = String.valueOf(seconds);
        String minuteString = String.valueOf(minutes);
        
        if (miliSecondString.length() == 1) miliSecondString = addZeroInFront(miliSecondString);

        if (secondString.length() == 1) secondString = addZeroInFront(secondString);

        if (minuteString.length() == 1) minuteString = addZeroInFront(minuteString);

        return (
            minuteString + ":" +
            secondString + ":" +
            miliSecondString
        );
    }

    private String addZeroInFront(String time) {
        return 0+time;
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
