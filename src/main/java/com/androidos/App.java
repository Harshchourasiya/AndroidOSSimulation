package com.androidos;

import javax.swing.*;
import java.awt.*;
import com.androidos.timer.TimerGUI;
public class App 
{
    public static void main( String[] args ) {
        JFrame f= new JFrame("Panel Example"); 
        TimerGUI clock = new TimerGUI(f);   
        Thread t1 = new Thread(clock);
        t1.start();     
        JPanel panel = clock.getPanel();
        f.getContentPane().add(BorderLayout.CENTER, panel);  
                f.setSize(400,400);    
                f.setLayout(null);    
                f.setVisible(true);    
    }
}
