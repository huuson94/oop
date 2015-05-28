/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.view.*;
import com.tag.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Spliterators;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.DataFormat;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

/**
 *
 * @author hs
 */
public class PageController extends Thread{

    private Page page;
    private final String defaultAddress = "";
    public void setPage(Page page) {
        this.page = page;
    }
    
    public Page getPage() {
        return page;
    }
    private String address = null;
    private SimpleAttributeSet pageStyle = new SimpleAttributeSet();

    public SimpleAttributeSet getPageStyle() {
        return pageStyle;
    }

    public void setPageStyle(SimpleAttributeSet pageStyle) {
        this.pageStyle = pageStyle;
    }
    
    private String checkAddress(String add) {
        if (add.startsWith("http://") || add.startsWith("https://")){
            return add;
        }
        else{
            return "http://" + add;
        }
    }

    public PageController() {
        address = "";
        page = new Page();
        StyleConstants.setFontFamily(pageStyle, "Courier New Italic");
        StyleConstants.setForeground(pageStyle, Color.BLACK);
        StyleConstants.setFontSize(pageStyle, 12);
        
        page.getAddressBar().addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        
                        address = checkAddress(event.getActionCommand());
                        
                        page.getHtmlBody().setText("");
                        try {
                            loadPage(address);
                        } catch (Exception ex) {
                            Logger.getLogger(AddressBar.class.getName()).log(Level.SEVERE, null, ex);
                            showErrorDialog(ex.getMessage());
                        }
                    }
                });
    }

    public void showPage() {
        page.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        page.setLocation(dim.width/2-page.getSize().width/2, dim.height/2-page.getSize().height/2);
    }

    public void loadPage(String address) {
        try {
            //clear page
            page.getHtmlBody().setText("");
            // refresh addressbar
            page.getAddressBar().setText(address);
            String  content = readHtml(address);
            org.jsoup.nodes.Document doc = Jsoup.parse(content);
            Element parent = doc.select("body").first();
            parseTag(parent);
            writeHistory(address);
        } catch (BadLocationException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.toString());
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.toString());
        } catch (Exception ex){
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.toString());
        }
    }
    
    private String readHtml(String address) throws MalformedURLException, IOException{
        String line = "";
        String fileContent = "";
        
        if ("".equals(address)) {
            return "";
        }
        address = checkAddress(address);
       
        URL url = new URL(address);

        URLConnection connection = url.openConnection();

        InputStream inputStream = connection.getInputStream();

        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        while (line != null) {
            line = bf.readLine();
            fileContent += "\n" + line;
        }
        return fileContent;
    }
    
    private void parseTag(Element cur) throws BadLocationException{
        int i = 0;
        if (cur == null) {
            return;
        }
        if (cur instanceof FormElement) {
            cur = (Element) cur;
        }
        boolean hasBlockParent = false;
        System.out.println(cur.tagName()+"\t"+cur.classNames()+"|"+cur.parent().tagName()+"."+cur.parent().className());
        if(cur.isBlock())
            page.getHtmlBody().getDocument().insertString(page.getHtmlBody().getStyledDocument().getLength(), "\n", getPageStyle());

        
        printTag(cur);
        Elements Tags = cur.children();

        if (Tags.size() != 0) {

            if (cur.isBlock()) {
                hasBlockParent = true;
            }
            for (i = 0; i < Tags.size(); i++) {
                parseTag((Tags.get(i)));
            }
            if (hasBlockParent == true) {
                
                page.getHtmlBody().getDocument().insertString(page.getHtmlBody().getStyledDocument().getLength(), "\n", getPageStyle());
                
            }
        }
    }
   
    
    private void printTag(Element cur) throws BadLocationException{
       
        switch (cur.tagName()) {
            case ("div"):
                DivTag d = new DivTag(cur.ownText());

                page.getHtmlBody().insertString(d.getText(), d.getStyle());
                break;
            case ("h1"):
                H1Tag h1 = new H1Tag(cur.ownText());
                //System.out.print(tag.text());
                //h1.setVisible(true);
                page.getHtmlBody().insertString(h1.getText(), h1.getStyle());
                break;
            case ("h2"):
                H2Tag h2 = new H2Tag(cur.ownText());
                //System.out.print(tag.text());
                //h1.setVisible(true);
                page.getHtmlBody().insertString(h2.getText(), h2.getStyle());
                break;
            case ("p"):
                PTag p = new PTag(cur.ownText());
                //System.out.print(tag.text());
                //p.setVisible(true);
                page.getHtmlBody().insertString(p.getText(), p.getStyle());
                break;
            case ("span"):
                SpanTag s = new SpanTag(cur.ownText());
                //System.out.print(tag.text());
                //s.setVisible(true);
                page.getHtmlBody().insertString(s.getText(), s.getStyle());
                break;
            case ("a"):
                ATag a = new ATag(cur.ownText());

                page.getHtmlBody().insertString(a.getText(), a.getStyle());
                break;
            case ("br"):
                page.getHtmlBody().insertString("\n", pageStyle);
                break;
            default:
                if(cur.ownText() != null)
                    page.getHtmlBody().insertString(cur.ownText(), pageStyle);
                break;
        }
        page.getHtmlBody().validate();
        page.getHtmlBody().repaint();

    }
    
    private void writeHistory(String address){
        
        try {
            DateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss dd/MM/yyyy");
            Date date = new Date();
            //System.out.println(dateFormat.format(date));
            FileWriter writer = new FileWriter("history.dat", true);
            writer.append(address);
            writer.append("\t");
            writer.append(dateFormat.format(date));
            writer.append("\n");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            showErrorDialog(ex.getMessage());
        }
        
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }
    
    private void showErrorDialog(String error){
        page.setErrorDialog(new ErrorDialog(error));
        page.getErrorDialog().setVisible(true);
        restartPage();
        
    }
    private void hideErrorDialog(){
        page.getErrorDialog().setVisible(false);
    }
    private void restartPage(){
        setPage(new Page());
        page.getAddressBar().setText(defaultAddress);
        loadPage(defaultAddress);
    }
}
