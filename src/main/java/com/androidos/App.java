package com.androidos;

import javax.swing.*;
import java.awt.*;
public class App 
{
    public static void main( String[] args ) {
        JFrame f= new JFrame("Panel Example"); 
        Home clock = new Home(f);   
        Thread t1 = new Thread(clock);
        t1.start();     
        JPanel panel = clock.getPanel();
        JPanel panel2 = new Navbar(f, panel).getPanel();
        f.getContentPane().add(BorderLayout.CENTER, panel);  
        f.getContentPane().add(BorderLayout.PAGE_END, panel2);
                f.setSize(400,400);    
                f.setLayout(null);    
                f.setVisible(true);    
    }
}
