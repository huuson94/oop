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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author hs
 */
public class Page extends JFrame{
    private AddressBar addressBar;
    private HtmlBody htmlBody;
    private Menu mnBar;
    private ErrorDialog errorDialog;
    
    public AddressBar getAddressBar() {
        return addressBar;
    }

    public HtmlBody getHtmlBody() {
        return htmlBody;
    }

    public Menu getMnBar() {
        return mnBar;
    }

    public ErrorDialog getErrorDialog() {
        return errorDialog;
    }

    public void setErrorDialog(ErrorDialog errorDialog) {
        this.errorDialog = errorDialog;
    }
    
    
    public Page(){
        
        super("HS Browser");
        this.mnBar = new Menu();
        this.setJMenuBar(mnBar);
        this.htmlBody = new HtmlBody();
        this.addressBar = new AddressBar();
        
        
        this.add(addressBar, BorderLayout.NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new JScrollPane(htmlBody), BorderLayout.CENTER);
	this.pack();
        
        this.setSize(800, 600);
        this.setVisible(false);
    }
}
