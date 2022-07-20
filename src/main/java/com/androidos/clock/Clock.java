package com.androidos.clock;

import javax.swing.*;
import java.awt.*;
import static com.androidos.data.Data.*;

public class Clock implements Runnable{
    private Time time;
    private JPanel panel;
    private JLabel clockTextLabel;
    
    public Clock() {
        time = new Time();
        panel = new JPanel(new BorderLayout());
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
        while (true) {
            setTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    private void setTime() {
        clockTextLabel.setText(time.getFormatedTime());
    }


    public JPanel getPanel() {
        return panel;
    }
    
}
