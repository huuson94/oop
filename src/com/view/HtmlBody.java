/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
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
        this.setDocument(new DefaultStyledDocument());
        
    }
    
    public void insertString(String text, SimpleAttributeSet style) throws BadLocationException, ArrayIndexOutOfBoundsException{
        this.getDocument().insertString(this.getDocument().getLength(), text, style);
    }
}
