//import java.util.*;

public class main
{
   public static void main(final String[] args) 
   {
	   //int scores = 10;
	   try
	   {
	   ProcessSent obj = new ProcessSent();
	   
	   /*double threshold = -1.03458;
	   String sentence = "the girl is reading a books";
	   String words = "girl read book";
	   */
	   
	   /*double threshold = -0.75953;
	   String sentence = "the boy is playing with the football";
	   String words = "boy play football";
	   */
	   
	   /*double threshold = -1.20998;
	   String sentence = "the dog is eating food";
	   String words = "dog eat food";
	   */
	   
	   //double threshold = -0.86137;
	   //String sentence = "the girl is sleeping on a bed";
	   //String words = "girl sleep bed";
	   String sentence = "";
	   String words="";
	   
	   double threshold = Double.parseDouble(args[0]);
	   
	   for (int i=1; i<4; i++)
	   {
		   words+= args[i]+" ";
	   }
	   for(int i=4; i<args.length; i++)
	   {
		   sentence += args[i]+" ";
	   }
	   
	   System.out.println(sentence);
	   	   
	   int scores = obj.scores(sentence, words, threshold);
	   System.out.println(scores);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.toString());
	   }
   }
}