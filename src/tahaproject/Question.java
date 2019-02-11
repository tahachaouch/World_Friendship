package tahaproject;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author arthas
 */
public class Question {
    private int id;
    private int id_question;
    String date_question = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    //Date date= new Date();
   // long time = date.getTime();
   // Timestamp date_question = new Timestamp(time);
    private String titre_question;
    private String contenu_question;
    int etat_question;


    public Question() {
    }


    
    
    public Question(int id,String date_question, String titre_question, String contenu_question) {
      this.id=id;
      this.date_question=date_question;
      this.titre_question=titre_question;
      this.contenu_question=contenu_question;
    }
    
    
    
    public Question(int id, int id_question, String date_question, String titre_question, String contenu_question) {
        this.id = id;
        this.id_question=id_question;
        this.date_question=date_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
    
        
    }
    

    

    public Question(int id, int id_question, String date_question, String titre_question, String contenu_question, int etat) {
        this.id = id;
        this.id_question=id_question;
        this.date_question=date_question;
        this.titre_question=titre_question;
        this.contenu_question=contenu_question;
        this.etat_question=etat_question;
        
    }

   public Question(int id_question, String titre_question, String contenu_question) {
         this.id_question=id_question;
         this.titre_question=titre_question;
         this.contenu_question=contenu_question;
    }

   
   public Question(int id_question)
   {
       this.id_question=id_question;
   }
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }*/

    public String getDate_question() {
        return date_question;
    }

    public void setDate_question(String date_question) {
        this.date_question = date_question;
    }

    public String getTitre_question() {
        return titre_question;
    }

    public void setTitre_question(String titre_question) {
        this.titre_question = titre_question;
    }

    public String getContenu_question() {
        return contenu_question;
    }

    public void setContenu_question(String contenu_question) {
        this.contenu_question = contenu_question;
    }

    public int getEtat() {
        return etat_question;
    }

    public void setEtat(int etat) {
        this.etat_question = etat;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", id_question=" + id_question + ", date_question=" + date_question + ", titre_question=" + titre_question + ", contenu_question=" + contenu_question + ", etat=" + etat_question + '}';
    }

    
    

 

  

 
    
    
    
    
}