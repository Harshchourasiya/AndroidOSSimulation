package com.androidos.stopwatch;

import javax.swing.*;

import com.androidos.app.App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.androidos.data.Data.*;
import static com.androidos.helper.Style.*;
public class Stopwatch extends App implements Runnable{
    private Watch watch;
    private JPanel panel;
    private JLabel watchTextLabel;
    private JButton startOrStopButton, resetButton;

    public Stopwatch(JPanel panel) {
        super(panel);
        
        this.panel = panel;
        watch = new Watch();
        watchTextLabel = new JLabel();
        startOrStopButton = new JButton();
        resetButton = new JButton();
        setPanel();
    }

    private void setPanel() {
        setWatchLabelText();
        setLabelClockStyle(watchTextLabel);
        setPanelStyle(panel);
        setStartOrStopButtonProperties();
        setResetButtonProperties();

        panel.add(watchTextLabel, BorderLayout.CENTER);
        panel.add(startOrStopButton, BorderLayout.BEFORE_LINE_BEGINS);
        panel.add(resetButton, BorderLayout.AFTER_LAST_LINE);
    }


    private void setWatchLabelText() {
        watchTextLabel.setText(watch.getStopWatchFormated());
    }
    private void setStartOrStopButtonProperties() {
        setStartOrStopButtonText();
        startOrStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watch.stopAndStartSwitch();
                setStartOrStopButtonText();
            }
        });
    }

    private void setStartOrStopButtonText() {
        if (watch.getIsStarted()) startOrStopButton.setText(STOP_STR);
        else startOrStopButton.setText(START_STR);
    }

    
    private void setResetButtonProperties() {
        resetButton.setText(RESET_STR);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watch.reset();
                setWatchLabelText();
                setStartOrStopButtonText();
            }
        });   
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.getName().equals(STOP_STR)) {
            if (watch.getIsStarted()) increaseTimeBy10MiliSeconds();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    private void increaseTimeBy10MiliSeconds() {
        watchTextLabel.setText(watch.increaseTimeBy10MiliSecondsAndReturn());
    }
    
}
