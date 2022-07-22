package com.androidos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import static com.androidos.data.Data.*;
public class Navbar {
    private JFrame frame;
    private JPanel homePanel, panel;
    private JButton recent, home, back;
    
    public Navbar(JFrame frame, JPanel homePanel) {
        this.frame = frame;
        this.homePanel = homePanel;
        panel = new JPanel(new FlowLayout());
        recent = new JButton(RECENT_STR);
        home = new JButton(HOME_STR);
        back = new JButton(BACK_STR);

        setPanel();
    }

    private void setPanel() {
        setRecentButtonProperties();
        setHomeButtomProperties();
        setBackButtomProperties();
        setPanelStyle();

        panel.add(recent);
        panel.add(home);
        panel.add(back);
        panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
    }

    private void setRecentButtonProperties() {
        recent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRecents();
            }

        });
    }

    private void showRecents() {
        recent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRecents();
            }

        });
    }

    private void openRecents() {
        replacePanel(new Recent().getPanel());
    }

    private void setHomeButtomProperties() {
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openHome();
            }

        });
    }

    private void openHome() {
        replacePanel(homePanel);
    } 

    // this is a duplicate code so remove this fast
    private void replacePanel(JPanel app) {
        frame.getContentPane().removeAll();;
        frame.getContentPane().add(app);
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }


    private void setBackButtomProperties() {
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO for now be can use home because its not affect my program now 
                // TODO But in future I will remove it if only I work on this 
                openHome();
            }

        });
    }


    // this is also a duplicate code so remove this as fast as you can
    private void setPanelStyle() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, SCREEN_HEIGHT - BOTTOM_BAR_HEIGHT,
                SCREEN_WIDTH, BOTTOM_BAR_HEIGHT);
    }

    public JPanel getPanel() {
        return panel;
    }

}
