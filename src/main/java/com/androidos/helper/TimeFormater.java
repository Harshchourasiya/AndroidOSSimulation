package com.androidos.helper;

public class TimeFormater {
    
    public TimeFormater() {}

    public String getTimeFormated(int minutes, int seconds, int miliSeconds) {
        String miliSecondString = String.valueOf(miliSeconds);
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
}
