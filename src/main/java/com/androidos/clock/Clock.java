package com.androidos.clock;

import javax.swing.*;

import com.androidos.app.App;

import java.awt.*;
import static com.androidos.data.Data.*;
import static com.androidos.helper.Style.*;
public class Clock extends App implements Runnable{
    private JPanel panel;

    private Time time;
    private JLabel clockTextLabel;
    
    public Clock(JPanel panel) {
        super(panel);
        time = new Time();
        this.panel = panel;
        clockTextLabel = new JLabel();
        setPanel();
    }

    private void setPanel() {
        setTime();
        setLabelClockStyle(clockTextLabel);
        setPanelStyle(panel);
        panel.add(clockTextLabel, BorderLayout.CENTER);
    }


    @Override
    public void run() {
        while (!Thread.currentThread().getName().equals(STOP_STR)) {
            setTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    private void setTime() {
        clockTextLabel.setText(time.getFormatedTime());
    }
    
}
