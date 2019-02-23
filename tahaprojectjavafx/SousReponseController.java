/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahaprojectjavafx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class SousReponseController implements Initializable {

   @FXML
    private TextField username;
   @FXML
    private TextField date;
   @FXML
    private TextArea contenu;
   @FXML
    private TextField G;
   @FXML
    private TextField B;
   @FXML
    private Button btn1;
   @FXML
    private Button btn2;
   @FXML
    private Button btn3;
    
    
   @FXML
private void retour(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}


   @FXML
private void Good(ActionEvent event) throws IOException, SQLException
{
   UtiliseObjetService obs=new UtiliseObjetService();
   RatingService rts = new RatingService();
   
   rts.ajouterRating(obs.getidreponsedb().get(0).getId_reponsedb());
   
   
   
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    
    
}


@FXML
private void Bad(ActionEvent event) throws IOException, SQLException
{
   UtiliseObjetService obs=new UtiliseObjetService();
   RatingService rts = new RatingService();
   
   rts.ajouterUnrating(obs.getidreponsedb().get(0).getId_reponsedb());
   
   
   
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousReponse.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    
    
}



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
       try {
            ReponseService rs = new ReponseService();
           
           UtiliseObjetService obs=new UtiliseObjetService();
           
          Reponse r=  rs.AfficherReponsesAvecTriRatePARID(obs.getidquestiondb().get(0).getId_reponsedb());
        
          
            System.out.println(r.getUsername());
          
            date.setText(r.getDate_reponse());
            date.setEditable(false);          
            
            contenu.setText(r.getContenu_reponse());
            contenu.setEditable(false);
            
            G.setText(String.valueOf(r.getRate()));
            contenu.setEditable(false);
            B.setText(String.valueOf(r.getUnrate()));
            contenu.setEditable(false);
            username.setText(r.getUsername());
            username.setEditable(false);
           
           
       
       } catch (SQLException ex) {
           Logger.getLogger(SousReponseController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }    
    
}
