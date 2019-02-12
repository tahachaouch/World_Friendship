package tahaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.sql.Timestamp;


/**
 *
 * @author arthas
 */
class QuestionService {
     Connection cnx;
    
    public QuestionService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

    void ajouterQuestion(Question q) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `question`(`id`,`date_question`, `titre_question`, `contenu_question`) VALUES ('"+q.getId()+"','"+q.getDate_question()+"','"+q.getTitre_question()+"','"+q.getContenu_question()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
void modifierQuestion(Question q) {
         try {
             
             String req = "UPDATE question set titre_question=?,contenu_question=? where id_question=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, q.getTitre_question());
             pstm.setString(2, q.getContenu_question());
             pstm.setInt(3, q.getId_question());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

void supprimerQuestion(Question q) {
         try {
             
             String req = "UPDATE question set etat_question=0 WHERE id_question=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, q.getId_question());
             pstm.executeUpdate();
             
             
             String req2 = "UPDATE reponse set etat_reponse=0 WHERE id_question=?";
             PreparedStatement pstm2 = cnx.prepareStatement(req2);
             pstm2.setInt(1, q.getId_question());
             pstm2.executeUpdate();
             
             
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
  /* void ajouterAlaBase2(Question q) {
         try {
             
             String req = "INSERT INTO `question`(`date_question`, `titre_question`, `contenu_question`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, q.getDate_question());
             pstm.setString(2, q.getTitre_question());
             pstm.setString(3, q.getContenu_question());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }*/
   

    

   ArrayList<Question> getAllQuestions() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM question";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
         //  System.out.println(id);
           int id_question= resultat.getInt("id_question");
           String date_question= resultat.getString("date_question");
           String titre_question = resultat.getString("titre_question");
           String contenu_question= resultat.getString("contenu_question");
           int etat_question=resultat.getInt("etat_question");
           retour.add(new Question(id,id_question,date_question,titre_question,contenu_question,etat_question));
            
        }
            
        return retour;
    
   }
   
   
   
   void afficherQuestionsComplet() throws SQLException
   {    
        int i=0;
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT id_question,titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id WHERE etat_question=1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
       
       String titre_question= resultat.getString("titre_question");
       System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
       System.out.println(date_question);
       String username= resultat.getString("username");
       System.out.println(username);
       
       //Calculer le nombre de commentaires pour chaque question.
       int id_question= resultat.getInt("id_question");
       String req1 = "SELECT id_reponse FROM reponse WHERE reponse.id_question="+id_question+" ";
       ResultSet resultat1 = stm1.executeQuery(req1);
       while(resultat1.next())
       {
         i++;
       }
       System.out.println("Nbr de Commentaire: "+i);
       
       
       
       
            
        }
        
        
       
    }
   
   
   void afficherQuestionsUser(int id) throws SQLException
   {
        Statement stm = cnx.createStatement();
        String req = "SELECT titre_question,date_question,username FROM question join fos_user on question.id=fos_user.id WHERE etat_question=1 AND question.id="+id+"";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
       
       String titre_question= resultat.getString("titre_question");
       System.out.println(titre_question);
       String date_question= resultat.getString("date_question");
       System.out.println(date_question);
       String username= resultat.getString("username");
       System.out.println(username);

            
        }
       
    }
           
   
   
   
   
   
   
 /*  ArrayList<Question> getQuestions() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT id,id_question,date_question,titre_question,contenu_question FROM question WHERE etat_question=1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt("id");
           int id_question= resultat.getInt("id_question");
           String date_question= resultat.getString("date_question");
           String titre_question = resultat.getString("titre_question");
           String contenu_question= resultat.getString("contenu_question");
           retour.add(new Question(id,id_question,date_question,titre_question,contenu_question));
            
        }
            
        return retour;
    
   }*/
   
}
   