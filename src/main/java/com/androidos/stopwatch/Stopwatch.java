package com.androidos.stopwatch;

import javax.swing.*;

import com.androidos.app.App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.androidos.data.Data.*;

public class Stopwatch extends App implements Runnable{
    private Watch watch;
    private static JPanel panel;
    private JLabel watchTextLabel;
    private JButton startOrStopButton, resetButton;

    public Stopwatch() {
        super(panel);

        watch = new Watch();
        panel = new JPanel(new BorderLayout());
        watchTextLabel = new JLabel();
        startOrStopButton = new JButton();
        resetButton = new JButton();
        setPanel();
    }

    private void setPanel() {
        setWatchLabelStyle();
        setPanelStyle();
        setStartOrStopButtonProperties();
        setResetButtonProperties();

        panel.add(watchTextLabel, BorderLayout.CENTER);
        panel.add(startOrStopButton, BorderLayout.BEFORE_LINE_BEGINS);
        panel.add(resetButton, BorderLayout.AFTER_LAST_LINE);
    }

    private void setPanelStyle() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    private void setWatchLabelStyle() {
        setWatchLabelText();
        watchTextLabel.setForeground(Color.WHITE);
        watchTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        watchTextLabel.setFont(new Font("SERIF", 0, 50));
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
            }
        });   
    }

    @Override
    public void run() {
        while (!Thread.currentThread().getName().equals(STOP_STR)) {
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

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
