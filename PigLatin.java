import java.util.Scanner;
/**
 * Prompts the user for a word and outputs a translation in pig latin
 * (first letter is moved to the end + ay)
 * @author Venkadesh Eswaranandam
 * @version 9/23/20
 */
public class PigLatin
{
   public static void main(String[] args)
   {
       Scanner input = new Scanner(System.in);
       System.out.println("Write the word to translate to pig latin:");
       String word = input.nextLine();
       // Use word.substring to construct word in pig latin
       String pigLatin = word.substring(1) + word.substring(0,1) + "ay";
       System.out.println(word + " in Pig Latin is " + pigLatin);
   }
}