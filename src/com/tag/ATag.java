/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import java.awt.Color;
import javax.swing.text.StyleConstants;

/**
 *
 * @author hs
 */
public class ATag extends InlineTag{

    public ATag(String text) {
        super(text);
        StyleConstants.setFontSize(style, 14);
        StyleConstants.setUnderline(style, true);
        StyleConstants.setForeground(style, Color.BLUE);
        
        
    }
    
}
