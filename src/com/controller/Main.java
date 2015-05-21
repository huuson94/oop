/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/**
 *
 * @author hs
 */
public class Main {
    public static void main(String[] args){
        
        PageController p = new PageController();
        p.start();
        p.showPage();
        p.getPage().getAddressBar().setText(p.getDefaultAddress());
        p.loadPage(p.getDefaultAddress());
        
    }
}
