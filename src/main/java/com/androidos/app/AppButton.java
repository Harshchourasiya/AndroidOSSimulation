package com.androidos.app;

import javax.swing.*;

import static com.androidos.helper.Style.*;
import static com.androidos.data.Data.*;
public class AppButton {

    private JButton button;
    private Icon icon;

    public AppButton(Class<?> getClass,String iconFileURL, String name) {
        icon = getImageIconFromResource(getClass, iconFileURL);
        button = new JButton(icon);
        button.setName(name);
        setIconButtonStyle(button);
    }


    public JButton getButton() {
        return this.button;
    }

}
