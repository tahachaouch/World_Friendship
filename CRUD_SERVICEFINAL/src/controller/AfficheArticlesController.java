/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.AffichageAjout;
import controller.GestionAjouter;
import controller.ListArticle;
import entities.Article;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheArticlesController implements Initializable {

    @FXML
    private ListView<Article> table;
    @FXML
    private TextField filterInputs;
    @FXML
    private Button ajout;
    @FXML
    private ImageView pic1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
        // TODO
        AffichageAjout aff= new AffichageAjout();
        
        // id.setCellValueFactory(new PropertyValueFactory<>("id"));
        // titre.setCellValueFactory(new PropertyValueFactory<>("titre_article"));
        /*  blog.setCellValueFactory(new PropertyValueFactory<>("blog"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        cree.setCellValueFactory(new PropertyValueFactory<>("cree"));
        modifie.setCellValueFactory(new PropertyValueFactory<>("modifie"));*/
        
        table.getItems().setAll(aff.afficherService());
        table.setCellFactory(lv -> new ListArticle());
    } catch (SQLException ex) {
        Logger.getLogger(GestionAjouter.class.getName()).log(Level.SEVERE, null, ex);
    }
        filterInputs.textProperty().addListener(new ChangeListener() {
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    try {
                        filterStudentList((String) oldValue, (String) newValue);
                    } catch (SQLException ex) {
                        Logger.getLogger(AfficheArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                
                
     }});
        if (filterInputs.getText()== null)
            {
             try {
                 ListArticle l =new ListArticle();
                 AffichageAjout pss=new AffichageAjout();
                 ObservableList<Article> lisst = pss.afficherService();
                 ObservableList<Article> obbb = FXCollections.observableArrayList(lisst);
                 l.getTags().setUserData(new PropertyValueFactory<> ("tags"));
                 l.getTitre_article().setUserData(new PropertyValueFactory<> ("titre_article"));
                 l.getImage().setUserData(new PropertyValueFactory<> ("image"));
                   
                 table.setItems(obbb);
             } catch (SQLException ex) {
                 Logger.getLogger(AfficheArticlesController.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        
        
        
        
        
    }
     public void filterStudentList(String oldValue, String newValue) throws SQLException {
         AffichageAjout ps = new AffichageAjout();
       ObservableList<Article> list = ps.afficherService();
            ObservableList<Article> observableStudentList = FXCollections.observableArrayList(list);
        ObservableList<Article> filteredList = FXCollections.observableArrayList();
        if(filterInputs == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(observableStudentList);
        }
        else {
            newValue = newValue.toUpperCase();
            for(Article p : table.getItems()) {
                String Name = p.getTitre_article();
                String ref = p.getTags();
                if(Name.toUpperCase().contains(newValue) || ref.toUpperCase().contains(newValue)) {
                    filteredList.add(p);
                }
            }
            table.setItems(filteredList);
        }
    
}
    @FXML
 public void AjouterArticle() throws SQLException{

  Dialog<Article> dialog = new Dialog<>();
        dialog.setTitle("Ajout Article");
        dialog.setHeaderText("Please specify…");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField texttitre_ar = new TextField("titre_article");
        TextField textimg = new TextField("image");
        TextArea textblog= new TextArea("blog");
        TextField texttags = new TextField("tags");
         
        
       
        dialogPane.setContent(new VBox(8, texttitre_ar, textimg, textblog,texttags));
        Platform.runLater(texttitre_ar::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                try {
                    // return new Article(texttitre_ar.getText(),
                    //  textimg.getText(),textblog.getText(),texttags.getText());
                    String titre_article =texttitre_ar.getText();
                    String image=textimg.getText();
                    String blog =textblog.getText();
                    String tags =texttags.getText();
                    
                    
                    Article a =new Article(titre_article,image, blog,tags);
                    AffichageAjout af=new AffichageAjout();
                    af.ajouterService(a);
                } catch (SQLException ex) {
                    Logger.getLogger(AfficheArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return null;
        });
        Optional<Article> optionalResult = dialog.showAndWait();
        optionalResult.ifPresent((Article article) -> {
            System.out.println(
                article.titre_article + " " + article.image + " " + article.blog+ " " + article.tags);
        });}
 
 
 
  @FXML
    private void addImage(MouseEvent event) {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic1.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }















      











