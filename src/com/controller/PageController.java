/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.view.*;

/**
 *
 * @author hs
 */
public class PageController {
    private Page page;
    private String defaultAddress = "";
    public PageController(){
        defaultAddress = "genk.vn";
        page = new Page();
    }
    public void showPage(){
        page.setVisible(true);
    }
}
