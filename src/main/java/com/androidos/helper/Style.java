package com.androidos.helper;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

import static com.androidos.data.Data.*;
public class Style {
    

    public static JPanel getNewJPanelWithBorderLayout() {
        return new JPanel(new BorderLayout());
    }

    public static void setPanelStyle(JPanel panel) {
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,
        SCREEN_WIDTH,SCREEN_HEIGHT-BOTTOM_BAR_HEIGHT); 
    }

    public static void setLabelClockStyle(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(FONT_NAME, 0, FONT_SIZE));
    }

    public static void setIconButtonStyle(JButton button) {
        button.setBackground(Color.BLACK);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
    }

}
