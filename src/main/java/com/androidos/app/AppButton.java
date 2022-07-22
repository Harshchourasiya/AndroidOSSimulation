package com.androidos.app;

import javax.swing.*;

public class AppButton {

    private JButton button;
    private Icon icon;
    private String name;

    public AppButton(String name,String iconFileURL) {
        this.name = name;
        icon = new ImageIcon(iconFileURL);
        button = new JButton(icon);
        button.setText(name);
    }


    public JButton getButton() {
        return this.button;
    }


    public Icon getIcon() {
        return this.icon;
    }

    public String getName() {
        return name;
    }

}
