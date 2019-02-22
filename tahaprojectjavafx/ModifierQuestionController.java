/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahaprojectjavafx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arthas
 */
public class ModifierQuestionController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextArea contenu;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    
    
    @FXML
private void RetourversQUestion(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}
    
    
    @FXML 
       public void handle(ActionEvent event) throws IOException {
           Question question=new Question();
             
              try {
                 QuestionService qs = new QuestionService();
                 UtiliseObjetService obs =new UtiliseObjetService();
                question = new Question(obs.getiduserdb().get(0).getId_questiondb(),titre.getText(),contenu.getText());
                 //  System.out.println(titre.getText());
                 //  System.out.println(contenu.getText());
                 //  System.out.println(obs.getiduserdb().get(0).getId_questiondb());
                qs.modifierQuestion(question);
                   //  Parent root= FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
                   //   nom.getScene().setRoot(root);
                   Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
               } catch (SQLException ex) {
                   Logger.getLogger(PublierQuestionController.class.getName()).log(Level.SEVERE, null, ex);
               }
                       
         }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

        try {
            QuestionService qs = new QuestionService();
            
            UtiliseObjetService obs=new UtiliseObjetService();
            
            
            
            Question q=  qs.afficherQuestionParId(obs.getidquestiondb().get(0).getId_questiondb());

            titre.setText(q.getDate_question());
            contenu.setText(q.getContenu_question());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }    
    
}
