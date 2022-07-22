package com.androidos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.util.List;
import java.awt.*;

import com.androidos.clock.Clock;
import com.androidos.clock.Time;
import com.androidos.stopwatch.Stopwatch;
import com.androidos.timer.TimerGUI;

import com.androidos.app.App;
import com.androidos.app.AppButton;

import static com.androidos.data.Data.*;

public class Home implements Runnable, ActionListener{ 

    private JFrame frame;

    private Time time;
    private JPanel panel;
    private JLabel homeClock;
    private List<AppButton> apps;
    public static Map<Thread, App> appThreads = new HashMap<>();

    public Home(JFrame frame) {
        this.frame = frame;

        time = new Time();
        panel = new JPanel(new BorderLayout());
        homeClock = new JLabel();
        apps = new ArrayList<>();
        setPanel();
    }

    private void setPanel() {
        storeApps();
        setAppsButtonProperties();
        setHomeClockStyle();
        setPanelStyle();

        panel.add(BorderLayout.CENTER, homeClock);
        panel.add(BorderLayout.PAGE_END, getAppsInOnePanel());
    }

    private void storeApps() {
        apps.add(new AppButton(STOPWATCH_APP_NAME, ""));
        apps.add(new AppButton(TIMER_APP_NAME, ""));
        apps.add(new AppButton(CLOCK_APP_NAME, ""));
    }

    private void setAppsButtonProperties() {
        for (AppButton app : apps) {
            app.getButton().addActionListener(this);
        }
    }

    private void setHomeClockStyle() {
        homeClock.setForeground(Color.WHITE);
        homeClock.setHorizontalAlignment(SwingConstants.CENTER);
        homeClock.setFont(new Font("SERIF", 0, 50));
    }

    private void setPanelStyle() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    private JPanel getAppsInOnePanel() {
        JPanel appsPanel = new JPanel(new FlowLayout());

        for (AppButton app : apps) appsPanel.add(app.getButton());

        appsPanel.setComponentOrientation(
            ComponentOrientation.LEFT_TO_RIGHT);

        return appsPanel;
    }

    @Override
    public void run() {
        while (true) {
            homeClock.setText(time.getFormatedTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        runApp(((JButton)e.getSource()).getText());
    }

    private void runApp(String name) {
        Thread t = isContainsThread(name);
        if (t != null) {
            replacePanel(appThreads.get(t));
        } else {
            App app = getApp(name);
            t = new Thread((Runnable)app);
            t.setName(name);
            t.start();
            appThreads.put(t, app);
            replacePanel(app);
        }
    }

    private Thread isContainsThread(String name) {
        for (Thread t : appThreads.keySet()) {
            if (t.getName().equals(name)) {
                return t;
            }
        }

        return null;
    }

    private App getApp(String name) {

        switch(name) {
            case STOPWATCH_APP_NAME :
              return new Stopwatch();

            case TIMER_APP_NAME:
              return new TimerGUI(frame);

            default :
            return new Clock();
        }

    }

    // TODO Code is duplicate So can be removed
    private void replacePanel(App app) {
        app.getPanel().setBackground(Color.BLACK);
        app.getPanel().setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
        frame.getContentPane().remove(panel);
        frame.getContentPane().add(app.getPanel());
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }


    public JPanel getPanel() {
        return panel;
    }
    
}
