/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author hs
 */
public class ErrorDialog extends JFrame{
    
    public ErrorDialog(String err){
        this.setTitle("ERROR");
        JTextField error = new JTextField(err);
        this.add(error, BorderLayout.CENTER);
        this.setSize(500,200);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
