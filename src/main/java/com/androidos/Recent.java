package com.androidos;


import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import com.androidos.app.App;

import static com.androidos.Home.appThreads;
import static com.androidos.data.Data.*;
public class Recent {
    private JPanel panel;
    private JButton cleanAll;

    public Recent() {
        panel = new JPanel(new BorderLayout());
        cleanAll = new JButton(CLEAR_ALL_STR);
        
        setPanel();
    }

    private void setPanel() {
        setClearAllButtonProperties();
        setPanelStyle();
        panel.add(getAllRunningAppsInOnePanel());
        panel.add(BorderLayout.PAGE_END, cleanAll);

    }

    private void setClearAllButtonProperties() {
        cleanAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllThreads();
            }

        });
    }

    private void removeAllThreads() {
        stopAllThreads();
        appThreads.clear();
        panel.remove(0);
        panel.invalidate();
        panel.repaint();
    }

    private void stopAllThreads() {
        for (Thread t : appThreads.keySet()) {
            t.setName(STOP_STR);
        }
    }

    private void setPanelStyle() {
        panel.setBackground(Color.GRAY);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    private JPanel getAllRunningAppsInOnePanel() {
        JPanel recentPanel = new JPanel(new FlowLayout());
        for (App app : appThreads.values()) {
            recentPanel.add(app.getPanel());
        }
        
        recentPanel.setBackground(Color.BLACK);
        panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
        return recentPanel;
    }



    public JPanel getPanel() {
        return panel;
    }
}
