/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author hs
 */
public class H1Tag extends BlockTag{
    
    public H1Tag(String text_t) {
        super(text_t);
        StyleConstants.setFontFamily(style, "Courier New Italic");
        StyleConstants.setForeground(style, Color.GREEN);
        StyleConstants.setFontSize(style, 26);
    }
}
