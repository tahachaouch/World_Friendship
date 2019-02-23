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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AcceuilController implements Initializable {

@FXML
    private TableView<Question> table;
@FXML
    private TableColumn<Question,Integer> idColumn;
@FXML
    private TableColumn<Question,Integer> iduColumn;
@FXML
    private TableColumn<Question,String> userColumn;
@FXML
    private TableColumn<Question,String> titreColumn;
@FXML
    private TableColumn<Question,String> dateColumn;
@FXML
    private TableColumn<Question,Integer> nbrColumn;
@FXML
    private Button btn;
@FXML
    private Button btn1;
@FXML
    private Button btn2;
@FXML
    private Button btn3;

   @FXML
private void AcceuilButtonAction(ActionEvent event) throws IOException
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
private void PublierQuestionButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PublierQuestion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}




@FXML
private void MesQuestionButtonAction(ActionEvent event) throws IOException
{
    try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("MesQuestions.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
} 
    


@FXML
private void ConsulterQuestionAcceuil(ActionEvent event) throws IOException
{
    try {
        // UtileObjets UO;
        
        
        
        Question question= table.getSelectionModel().getSelectedItem();
        //UO.(question.getId_question());
        /*UtileObjet ob =new UtileObjet();
        UtiliseObjetService obs=new UtiliseObjetService();
        obs.setidquestiondb(question.getId_question());*/
        UtiliseObjetService obs=new UtiliseObjetService();
       obs.setidquestiondb(question.getId_question());
      //  System.out.println(question.getId_question());
       // System.out.println(question.getId());
        if(question.getId()==obs.getiduserdb().get(0).getId_userdb())
        {Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestion.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();}
        else
        {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SousQuestionNU.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        }
    } catch (SQLException ex) {
        Logger.getLogger(MesQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    

}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            QuestionService qs = new QuestionService();
            ArrayList<Question> questions;
            try {
                /*QuestionService qss= new QuestionService();
                    Question q=new Question();
                   ArrayList<Question> questionss = qss.getAllQuestions();
                   questionss.forEach(e->System.out.println(e));*/
                   
                questions = (ArrayList<Question>) qs.afficherQuestionsComplet();
                ObservableList obs = FXCollections.observableArrayList(questions);
               // System.out.println(obs);
                table.setItems(obs);
                iduColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                idColumn.setCellValueFactory(new PropertyValueFactory<>("id_question"));
                userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
                titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre_question"));
                dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_question"));
                nbrColumn.setCellValueFactory(new PropertyValueFactory<>("nbr_comment"));
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
