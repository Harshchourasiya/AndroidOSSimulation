package com.androidos.clock;

import javax.swing.*;

import com.androidos.app.App;

import java.awt.*;
import static com.androidos.data.Data.*;

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
        setClockLabelStyle();
        setPanelStyle();
        panel.add(clockTextLabel, BorderLayout.CENTER);
    }

    private void setPanelStyle() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    private void setClockLabelStyle() {
        setTime();
        clockTextLabel.setForeground(Color.WHITE);
        clockTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockTextLabel.setFont(new Font("SERIF", 0, 50));
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
    

    // @Override
    // public JPanel getPanel() {
    //     return panel;
    // }
    
}
