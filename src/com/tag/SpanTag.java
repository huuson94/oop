/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import javax.swing.text.StyleConstants;

/**
 *
 * @author hs
 */
public class SpanTag extends InlineTag{

    public SpanTag(String text) {
        super(text);
        StyleConstants.setFontSize(style, 13);
      
    }
    
}
