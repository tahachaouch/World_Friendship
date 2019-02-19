/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldfriendship.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import worldfriendship.Entities.Event;
import worldfriendship.Services.EventService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddEventController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker dateS;
    @FXML
    private DatePicker dateE;
    @FXML
    private TextField adresseE;
    @FXML
    private TextField nbrPlace;
    @FXML
    private TextField typeHbergement;
    @FXML
    private TextField adresseHebergement;
    @FXML
    private Button ajouterB;
    @FXML
    private TextField typeEvent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addEvent(ActionEvent event) throws IOException {
        EventService eventService = new EventService();
        Event newEvent  = new Event();
        newEvent.setTitle_event(title.getText());
        newEvent.setDescription_event(description.getText());
        newEvent.setAdresse_Event(adresseE.getText());
        newEvent.setType_event(typeEvent.getText());
        
        Date dateSt = Date.valueOf(dateS.getValue());
        Date dateEd = Date.valueOf(dateE.getValue());
        newEvent.setStartdateevent(dateSt);
        newEvent.setEnddateevent(dateEd);
        
        newEvent.setNbrplace_event(Integer.parseInt(nbrPlace.getText()));
        newEvent.setImage_Event("exemple");
        newEvent.setAdressehebergement(adresseHebergement.getText());
        newEvent.setType_hebergement(typeHbergement.getText());
        
        eventService.addevent(newEvent);
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/ShowEvent.fxml"));
            Parent root = loader.load();
            //ascenseur.getScene().setRoot(root);
    }
    
}
