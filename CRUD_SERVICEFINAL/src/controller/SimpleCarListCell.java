/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Article;
import javafx.scene.control.ListCell;

/**
 *
 * @author ASUS
 */
public class SimpleCarListCell extends ListCell<Article> { 
  
    //@Override 
    @Override
    protected void updateItem(Article item, boolean empty) { 
        super.updateItem(item, empty); 
        setText(null); 
        if (!empty && item != null) { 
            final String text = String.format("%s ,%s,%s", item.getImage(),item.getTags(), item.getTitre_article()); 
            setText(text); 
        } 
    } 
}