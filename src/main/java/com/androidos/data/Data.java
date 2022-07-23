package com.androidos.data;


import javax.swing.ImageIcon;

public class Data {

    public final static int SCREEN_WIDTH = 400;
    public final static int SCREEN_HEIGHT = 450;
    public final static int BOTTOM_BAR_HEIGHT = 70;
    public final static int FONT_SIZE = 50;
    public final static String FONT_NAME = "SERIF";

    public final static String STOP_STR = "Stop";
    public final static String START_STR = "Start";
    public final static String RESET_STR = "Reset";
    public final static String RECENT_STR = "Recent";
    public final static String HOME_STR = "Home";
    public final static String BACK_STR = "Back";
    public final static String CLEAR_ALL_STR = "Clear All";
    public final static String APP_NAME_STR = "Multithreading";


    public final static String STOPWATCH_APP_NAME = "Stopwatch";
    public final static String TIMER_APP_NAME = "Timer";
    public final static String CLOCK_APP_NAME = "Clock";


    public final static String SRC_FOLDER = "src//";
    public final static String ICON_FOLDER = SRC_FOLDER + "icon//";
    public final static String HOME_IMAGE_URL = getImageURL("home.png");
    public final static String BACK_IMAGE_URL = getImageURL("back.png");
    public final static String RECENT_IMAGE_URL = getImageURL("recent.png");
    
    public final static String CLOCK_ICON_URL = getIconURL("clock.png");
    public final static String STOPWATCH_ICON_URL = getIconURL("stopwatch.png");
    public final static String TIMER_ICON_URL = getIconURL("timer.png");

    public static String getImageURL(String file) {
        return SRC_FOLDER +file;
    }

    public static String getIconURL(String file) {
        return ICON_FOLDER +file;
    }

    public static ImageIcon getImageIconFromResource(Class<?> getClass, String name) {
        return new ImageIcon(getClass.getResource(name));
    }
}
