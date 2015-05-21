/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author hs
 */
public class HtmlBody extends JTextPane{
    
    public HtmlBody() {
        super();
        this.setLayout(new FlowLayout());
        this.setEditable(false);
        this.setSize(800, 600);
        this.setContentType("text/html");

        HTMLEditorKit html_kit = new HTMLEditorKit();
        this.setEditorKit(html_kit);
        this.setDocument(new HTMLDocument());
        
        
        //this.setLineWrap(true);
        
    }
}