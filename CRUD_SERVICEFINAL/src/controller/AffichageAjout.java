/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Article;

import connexion.conDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
/**
 *
 * @author karim
 */
public class AffichageAjout {
   
static Connection cnx;
    
    public AffichageAjout() throws SQLException {
       cnx = conDB.getInstance().getCnx();
    }    
    public static int ajouterService(Article article) {
        int a=0;
     try {
            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            
            String requete
                    = "INSERT INTO article (titre_article, blog, image, cree, modifie, archive,tags) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(requete);
           // st.setInt(1,article.getId());
           
            st.setString(1,article.getTitre_article());
            st.setString(2,article.getBlog());
            st.setString(3,"file:" + article.getImage()); 
        
            st.setDate(4, date_sql);
                  st.setDate(5, date_sql);
            
            st.setBoolean(6, false);
            st.setString(7,article.getTags());
           
           
            st.executeUpdate();
            System.out.println("Article ajouté");
            a=1;
            if(a==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article bien ajouté !!");
            alert.showAndWait();
            
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Ajout article");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Article Non  Ajouté !!");
            alert.showAndWait();
        }
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
     return a;
      }
    public ObservableList<Article> afficherService() throws SQLException
      {
          
         ObservableList<Article> myList = FXCollections.observableArrayList();
      
       
            Statement st = cnx.createStatement();
            String requete = "SELECT * FROM `Article` ";
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                int id=rs.getInt("id");
              
                String titre_article=rs.getString("titre_article");
                String blog=rs.getString("blog");
                String image=rs.getString("image");
                Date cree=rs.getDate("cree");
                Date modifie=rs.getDate("modifie");
                Boolean archive=rs.getBoolean("archive");
                String tags=rs.getString("tags");
            myList.add(new Article(id,titre_article,blog,image,cree,modifie,archive,tags));
  }
        return myList;
      }    
    
    public static int    update(int id, Article a ) throws SQLException  {
        int st=0;
        
            
        
   String req = "UPDATE `Article` Set `titre_article`=?,`blog`=? WHERE `id`='"+id+"' "; 
     PreparedStatement pstm     =   cnx.prepareStatement(req);
     pstm.setString(1, a.getTitre_article());
     pstm.setString(2, a.getBlog());
     st=pstm.executeUpdate();
     return st ; 
}
public void   delete(int id) throws SQLException {
    int st=0 ;
    
          String req = "DELETE FROM `Article` WHERE id=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
       pstm.setInt(1, id);
        pstm.executeUpdate();
        cnx.close();
    }

public static Article getServiceId(int id) throws SQLException{
    Article s =new Article();
    String req="SELECT * FROM Article WHERE id=?";
     PreparedStatement pstm     =   cnx.prepareStatement(req);
     pstm.setInt(1, id);
     ResultSet rst =pstm.executeQuery();
     if(rst.next()){
         
      s.setId(rst.getInt(1));
      s.setTitre_article(rst.getString(3));
      s.setBlog(rst.getString(4));
    
     }
  return s;  
}
    
}
