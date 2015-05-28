/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.tag.Writeable;
import javax.swing.JTextField;

/**
 *
 * @author hs
 */
public class AddressBar extends JTextField implements Writeable{
    public AddressBar(){
        
    }
    @Override
    public void insertString(String text){
        super.setText(text);
    }
}
