/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;

/**
 *
 * @author hs
 */
 public class BlockTag extends Tag{

    public BlockTag(String text)  {
        super(text);
        
    }
    
    @Override
     public String getText(){
        if(super.getText() != null) 
            return super.getText() + "\n";
        else return "";
    }
    
}
