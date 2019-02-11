package tahaproject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author arthas
 */
public class TahaProject {


    public static void main(String[] args) throws SQLException {
        
       QuestionService qs= new QuestionService();
       ReponseService rs= new ReponseService();
       RatingService rts=new RatingService();
       
       Question q=new Question();
       Question q2=new Question();
       Question q3=new Question();
       Reponse r1=new Reponse();
       Reponse r2=new Reponse();
       Reponse r3=new Reponse();
       Rating rt1=new Rating();
       
       
       rt1=new Rating(2,2);
      // rts.ajouterRating(rt1);
      
        
       //r1=new Reponse(10,10,r1.getDate_reponse(),"test");
     //  rs.ajouterReponse(r1);
     
    // r2=new Reponse(1,"LOl again");
    // rs.modifierReponse(r2);
     
    
  //  r3=new Reponse(1);
   // rs.supprimerReponse(r3);
       
     //  q = new Question(123,q.getDate_question(),"test","hello");
      // qs.ajouterQuestion(q);
     //  q2 = new Question(35,"lol","no");
      // qs.modifierQuestion(q2);
      
      //q3=new Question(35);
    //  qs.supprimerQuestion(q3);
        
       // ArrayList<Question> allquestions = qs.getAllQuestions();
      //  allquestions.forEach(e->System.out.println(e));
     
        
        //ArrayList<Reponse> allreponses = rs.getAllReponses();
      //  allreponses.forEach(e->System.out.println(e));
      
      
      /*  ArrayList<Question> questions = qs.getQuestions();
        questions.forEach(e->System.out.println(e));*/
      

      rts.ajouterRating(rt1);
    }
    
}
