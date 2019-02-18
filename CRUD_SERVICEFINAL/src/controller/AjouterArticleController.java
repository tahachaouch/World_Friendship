/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.AffichageAjout;
import entities.Article;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterArticleController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txttitre;
    @FXML
    private TextField txtimage;
    @FXML
    private TextArea txtblog;
    @FXML
    private TextField txttags;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
     @FXML
    private void ajouter(ActionEvent event) throws SQLException {
         String titre_article =txttitre.getText();
         String image=txtimage.getText();
 String blog =txtblog.getText();
 String tags =txttags.getText();
 
 
 Article a =new Article(titre_article,image, blog,tags);
 AffichageAjout af=new AffichageAjout();
 af.ajouterService(a);
     
 
  
        
    }
    
}
