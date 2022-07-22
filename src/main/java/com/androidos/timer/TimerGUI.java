package com.androidos.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.androidos.app.App;
import static com.androidos.data.Data.*;

public class TimerGUI extends App implements Runnable{

    private static JPanel panel;
    private JLabel timerLabel;
    private JSpinner timeSetter;
    private JButton start, reset;
    private Timer timer;
    private JFrame frame;

    private final String TIME_END_MESSAGE = "Time is Up";

    public TimerGUI(JFrame frame) {
        super(panel);
        this.frame = frame;

        panel = new JPanel(new BorderLayout());
        timerLabel = new JLabel();
        timeSetter = new JSpinner();
        timer = new Timer();
        start = new JButton();
        reset = new JButton();
        setPanel();
    }

    private void setPanel() {
        setTimerLabelTextStyle();
        setTimerSetterProperties();
        setStartButtonProperties();
        setResetButtonProperties();
        setPanelStyle();

        panel.add(BorderLayout.CENTER, timerLabel);
        panel.add(BorderLayout.PAGE_END, timeSetter);
        panel.add(BorderLayout.PAGE_START, start);
        panel.add(BorderLayout.EAST, reset);

    }

    private void setTimerLabelTextStyle() {
        setTimerLabelText();
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font("SERIF", 0, 50));
    }

    private void setTimerLabelText() {
        timerLabel.setText(timer.decreaseTimeBy10MilisecondsAndReturn());
    }

        
    private void setTimerSetterProperties() {
        SpinnerModel value =  
        new SpinnerNumberModel(10, 
           1,   
           60,   
           1);
           timeSetter.setModel(value);  
    }


    private void setStartButtonProperties() {
        setStartButtonText();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.setTime(Integer.parseInt(timeSetter.getValue().toString()));
                timer.startOrStopTimer();
                setStartButtonText();        
            }
            
        });
    }

    private void setStartButtonText() {
        if (timer.getIsTimerStarted()) start.setText(STOP_STR);
        else start.setText(START_STR);
    }

    private void setResetButtonProperties() {
        reset.setText(RESET_STR);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.reset();      
                setTimerLabelText();
                setStartButtonText();  
            }
            
        });
    }

    private void setPanelStyle() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    @Override
    public void run() {
        while (!Thread.currentThread().getName().equals(STOP_STR)) {
            if (timer.getIsTimerStarted()) runTimer();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }

    private void runTimer() {
        if (timer.isTimerEnd()) {
            openEndDialogBox();
        } else setTimerLabelText();
    }

    private void openEndDialogBox() {
        timer.startOrStopTimer();
        setTimerLabelText();
        setStartButtonText();
        JOptionPane.showMessageDialog(frame, TIME_END_MESSAGE);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
