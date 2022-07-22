package com.androidos;

import javax.swing.*;
import java.awt.*;

import static com.androidos.data.Data.*;
public class Main 
{
    public static void main( String[] args ) {
        startApp();
    }

    private static void startApp() {
        JFrame frame = new JFrame(APP_NAME_STR); 
        Home home = new Home(frame);   
        Thread t1 = new Thread(home);
        t1.start();     
        JPanel homePanel = home.getPanel();
        JPanel navbarPanel = new Navbar(frame, homePanel).getPanel();
        frame.getContentPane().add(BorderLayout.CENTER, homePanel);  
        frame.getContentPane().add(BorderLayout.PAGE_END, navbarPanel);
        frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);    
        frame.setLayout(null);    
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);    
    }
}
