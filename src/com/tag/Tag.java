/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author hs
 */
abstract public class Tag {

    protected SimpleAttributeSet style = new SimpleAttributeSet();
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Tag(String text) {
        this.text = text;
        StyleConstants.setFontFamily(style, "Courier New Italic");
        StyleConstants.setForeground(style, Color.BLACK);
        StyleConstants.setFontSize(style, 12);

    }

    public SimpleAttributeSet getStyle() {
        return style;
    }

}
