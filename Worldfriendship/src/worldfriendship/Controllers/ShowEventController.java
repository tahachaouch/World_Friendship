/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import worldfriendship.Entities.Event;
import worldfriendship.Services.EventService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ShowEventController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label discription;
    @FXML
    private Label adresseE;
    @FXML
    private Label typeE;
    @FXML
    private Label nbrplace;
    @FXML
    private Label typeH;
    @FXML
    private Label adresseH;
    @FXML
    private Label startD;
    @FXML
    private Label endD;
    @FXML
    private Button delete;
    Event newEvent ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* 
        try {
            EventService eventService = new EventService();
            
            newEvent=eventService.afficherEventById(3);
            title.setText(newEvent.getTitle_event());
            discription.setText(newEvent.getDescription_event());
            adresseE.setText(newEvent.getAdresse_Event());
            typeE.setText(newEvent.getType_event());
            nbrplace.setText(String.valueOf(newEvent.getNbrplace_event()));
            typeH.setText(newEvent.getType_hebergement());
            adresseH.setText(newEvent.getAdressehebergement());
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
            startD.setText(sdf1.format(newEvent.getStartdateevent()));
            endD.setText(sdf1.format(newEvent.getEnddateevent()));

            
         
        } catch (SQLException ex) {
            Logger.getLogger(ShowEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }    

    @FXML
    private void deleteEvent(ActionEvent event) throws SQLException {
         EventService eventService = new EventService();
         eventService.deleteEvent(newEvent);
          Stage stage = (Stage) delete.getScene().getWindow();
         stage.close();
    }
    
}
