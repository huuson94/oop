/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.StyleConstants;

/**
 *
 * @author hs
 */
public class PTag extends BlockTag{

    public PTag(String text) {
        super(text);
        StyleConstants.setFontSize(style, 15);
    }
    
}
