import java.util.Scanner;
/**
 * Name of the Program: VeryfunMadlib
 * 
 * Purpose: Prompts the user to input words that will then get inserted into a small story
 * 
 * @author Comingupwithnames
 * 
 * @version Ver 2
 * ------------------------------
 * last updated:  Feb 3, 2021
 * finished: Feb 3, 2021
 * ------------------------------ 
 * Deficiencies: Don't overload the integer limit, and avoid third person singular verbs or else the story sounds weird.
 */
public class Madlib 
{
    
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner (System.in);
        
        //Explains the instructions to the code
        System.out.println("Hello! This is the first CS 203 assignment!");
        System.out.println("Here you will enter certain verbs, nouns, ");
        System.out.println("and anything else to write your own story!");
        
        //Stores a first and last name that is longer than one word
        System.out.print("Input your first and last name:");
        String firstAndLastName = keyboard.next();
        firstAndLastName += keyboard.nextLine(); 
        
        System.out.print("Input an age:");
        int age = keyboard.nextInt();
        
        System.out.print("Input an adjective, make it wild:");
        String firstAdjective = keyboard.next();
        
        //Stores a plural noun that may be more than one word
        System.out.print("Input a plural noun:");
        String pluralNoun = keyboard.next();
        pluralNoun += keyboard.nextLine(); //Outputs the rest of your plural noun if needed
        
        System.out.print("Input a verb:");
        String verb = keyboard.next();
        
        
        System.out.print("Input another adjective, make it less wild:");
        String secondAdjective = keyboard.next();
        
        //Stpres a place or location that may be more than one word long.
        System.out.print("Input a place or location:");
        String location = keyboard.next();
        location += keyboard.nextLine(); 
        
        //Stores a famous person's name if it is longer than one word.
        System.out.print("Input a famous person's name, alive or deceased:");
        String famousPerson = keyboard.next();
        famousPerson += keyboard.nextLine(); 
        
        System.out.println("Input a first name:");
        String firstName = keyboard.next();
        
        //Computes a random integer with the five integer inputs.
        System.out.print("Input the first nonzero integer:");
        int firstInt = keyboard.nextInt();
        System.out.print("Input the second nonzero integer:");
        int secondInt = keyboard.nextInt();
        System.out.print("Input the third nonzero integer:");
        int thirdInt = keyboard.nextInt();
        System.out.print("Input the fourth nonzero integer:");
        int fourthInt = keyboard.nextInt();
        System.out.print("Input the fifth nonzero integer:");
        int fifthInt = keyboard.nextInt();
        int finalInt = ((((firstInt - thirdInt)/fifthInt)%secondInt)*fourthInt);
        
        System.out.println();
        
        //Outputs the wonderful story
        System.out.println(firstAndLastName + " has a very " + firstAdjective + " elephant.");
        System.out.println("This elephant is " + age + " years old and one day the elephant ");
        System.out.println("went out for a walk, and on this walk he found " + pluralNoun);
        System.out.println("and decided to " + verb + " them.");
        System.out.println("After " + finalInt + " seconds, the elephant started to feel " + secondAdjective);
        System.out.println("and decided to visit " + location + " and found the love of his life");
        System.out.println("and that was " + famousPerson);
        
        System.out.println();
        System.out.println();
        
        System.out.println("Thank you for coming to my " + firstName + "talk.");
    }
}
