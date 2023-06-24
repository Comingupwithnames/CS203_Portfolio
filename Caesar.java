import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
/**
 * A program that takes an encrypted message in ROT13 and translates it back into english while also drawing a histogram from two sample arrays, one with labels and one with values
 *
 * @author Comingupwithnames
 * @version Version 2
 */
public class Caesar
{
    /**
     * This method will translate a text file to a string to be compared below
     *
     * @param  String filename
     * @return    String sb
     */
    public static String loadFile(String filename)
    {
        Scanner in;
        try{
            in = new Scanner(new FileReader(filename));
        }
        catch(IOException e)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

    /**
     * This method will assign characters of the alphabet to integers to compare to other ones later
     *
     * @param  char letter, int key
     * @return    char letter
     */
    public static char translateChar(char letter, int key)
    {
        int c;        
        if(letter >= 'A' && letter <= 'M' || letter>='a'&&letter<='m')//Assigns the first half of the alphabet to integers
        {
            c=(int)letter+key; //converts the ASCII number to a character then shifts it
            letter=(char)c; //converts the character into the newly shifted character
        }
        else if (letter>='N'&&letter<='Z'||letter>='n'&&letter<='z') //Assigns the last half of the alphabet to integers
        {
            c=(int)letter-key; //converts the ASCII number to a character then shifts it
            letter=(char)c;//converts the character into the newly shifted character
        }
        return letter;
    }

    /**
     * This method will translate the characters of a string with respect to the key
     *
     * @param  String secret, int key
     * @return    String secret
     */
    public static String translate(String secret, int key)
    {
        for (int i = 0; i < secret.length(); i++)
        {
            char c = secret.charAt(i);
            if(secret.charAt(i)<65||secret.charAt(i)>122) //checks to see if character at i is special or not
            {
                System.out.print(secret.charAt(i));  
            }
            else
            {
                c=translateChar(c,key);
                System.out.print(c);      
            }
        }
        System.out.println();
        return secret;
    }

    /**
     * Takes an array of labels and plots them with another array of values to create a histogram.
     *
     * @param  double[]histogramArray, String[]labels - the double takes a normalized data set and an array of "labels" and plots them to create a histogram
     * @return    void
     */
    public static void drawHistogram(double[] histogramArray,String[]labels)
    {
        for (int i = 0; i<histogramArray.length;i++)
        {
            System.out.print("\n" + labels[i] + " "); //Prints the label and then the number of stars afterwards
            for(double j = .02;j<histogramArray[i];j+=.02)//This takes the value for histogramArray[i] if it is greater than .02 and prints out * for every .02 up until it reaches the value for histogramArray[i]
            {
                System.out.print(" *");    
            }
        }
        System.out.println(); 
    }

    /**
     * A method that normalizes the data an an array into an array of percentages instead.
     *
     * @param  int[]inputArray - an input array calculated from one of the other methods or created in main
     * @return    double[]newArray - the normalized array for the data set
     */
    public static double[] normalizeArray(int[] inputArray)
    { 
        double[] normalizedArray = new double[inputArray.length];//Initializes a new double array and sets its length equal to the length of the input array
        int i;
        int sum = 0;
        for(i=0;i<inputArray.length;i++)
        {
            normalizedArray[i]=inputArray[i];//transfers the integers in inputArray over to the double array so dividing is easier  
        }
        for(i=0;i<normalizedArray.length;i++)
        {
            sum += normalizedArray[i];//adds up all the values in the new array
        }

        for(int k=0;k<normalizedArray.length;k++)
        {
            normalizedArray[k] = (normalizedArray[k]/sum);//Divides the current value for newArray and sets it equal to that current value divided by the sum
        }
        return normalizedArray;
    }

    /**
     * A method to create a histogram from a string of text
     *
     * @param  String text
     * @return    int[] letterArray
     */
    public static int[] createLetterHistogram(String text)
    {
        text = text.toLowerCase();//Puts the entire string to lower case
        char[] c = text.toCharArray();//puts the string of text to an array of characters so they can be used in the for loops below
        int cLength = c.length; //Initializes the length of the new array
        int[] letterArray = new int[26];//Initialized another integer array that is as long as there are letters in the alphabet
        int count = 0;
        int index = 0;

        for(char i ='a'; i<='z'; i++)//Itterates through the letters a-z for the entire text in the loop below
        {
            count = 0;
            for(int j=0; j<text.length(); j++) 
            {
                if(text.charAt(j) == i)//Checks every letter in the string to see if they match the letter that is currently being looked for
                {
                    count++;   
                }
            }
            if(index<letterArray.length)//Checks the current index to set the right frequency to the right value
            {
                letterArray[index]=count;
                index++;//Adds one to the index
            }
            else if(count == 0)
            {
                letterArray[index]=0;
                index = index+1;
            }
        }

        return letterArray;
    }

    /**
     * This method will compute the distance from one histogram to another using a formula shown on the homework
     *
     * @param  double[]histogramX, double[] histogramY
     * @return    double distance
     */
    public static double histogramDistance(double[]histogramX, double[] histogramY)
    {
        double distance=0;
        double differenceSquared = 0;
        double sum = 0;
        for(int i = 0; i<histogramX.length;i++)
        {
            differenceSquared = (histogramX[i]-histogramY[i])*(histogramX[i]-histogramY[i]);//Takes the difference of the array value at index i
            sum += differenceSquared;//Adds the difference to the sum
        }
        distance = Math.sqrt(sum);//Square roots the sum
        return distance;
    }

    /**
     * The main method that calls upon the above methods to perform the cipher as well as draw a histogram
     *
     * @param  None
     * @return    void
     */
    //The main method that calls upon the above methods to perform the cipher as well as draw a histogram
    public static void main(String[]args)
    {
        // String secret = "Pnrfne pvcure? V zhpu cersre Pnrfne fnynq!";
        // String history = "Vs ur unq nalguvat pbasvqragvny gb fnl, ur jebgr vg va pvcure, gung vf, ol fb punatvat gur beqre bs gur yrggref bs gur nycunorg, gung abg n jbeq pbhyq or znqr bhg.";
        // String triumvirate = "Ur jnf gur zbfg fhpprffshy guveq bs gur gevhzivengr!";
        // secret = translate(secret,13); 
        // history = translate(history,13);
        // triumvirate = translate(triumvirate,13);

        int[] histogramArray = {2,3,4,8,1,2}; //The values for a simple one-dimensional histogram
        double[] newHistogramArray = normalizeArray(histogramArray);//normalizes the data in histogramArray

        String vText = "Voila! In view, a humble vaudevillian veteran, cast vicariously as both victim and villain by the vicissitudes of Fate. This visage, no mere veneer of vanity,is a vestige of the vox populi, now vacant, vanished. However, this valorous visitation of a by-gone vexation, stands vivified, and has  vowed to vanquish these venal and virulent vermin van-guarding vice and vouchsafing the violently vicious and voracious violation of volition. The only verdict is vengeance; a vendetta, held as a votive, not in vain, for the value and veracity of such shall one day vindicate the vigilant and the virtuous. Verily, this vichyssoise of verbiage veers most verbose, so let me simply add that it is my very good honor to meet you and you may  call me V. And you would be?";
        String bookOneText = loadFile("Book 1.txt");
        String bookTwoText = loadFile("Book 2.txt");

        String[] labels = {"a","b","c","d","e","f"}; //A simple array of labels for the histogram.
        String[] labels2 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; //A simple array of labels for another histogram.

        int[]letterHistogramArray = createLetterHistogram(vText);//Creates a frequency array of letters out of integers
        double[] normalizedLetterFrequencies = normalizeArray(letterHistogramArray);//normalizes the data in letterHistogramArray
        int[] bookOneArray = createLetterHistogram(bookOneText);//Creates a frequency array of letters out of integers
        double[] normalizedBookOne = normalizeArray(bookOneArray);//normalizes the data in bookOneArray
        int[] bookTwoArray = createLetterHistogram(bookTwoText);//Creates a frequency array of letters out of integers
        double[] normalizedBookTwo = normalizeArray(bookTwoArray);//normalizes the data in bookTwoArray

        drawHistogram(newHistogramArray,labels);//Creates the histogram for newHistogramArray
        drawHistogram(normalizedLetterFrequencies,labels2);//Creates the histogram for normalizedLetterFrequencies
        drawHistogram(normalizedBookOne,labels2);//Creates the histogram for normalizedBookOne
        drawHistogram(normalizedBookTwo,labels2);//Creates the histogram for normalizedBookTwo

        double distanceX = histogramDistance(normalizedBookOne,normalizedBookTwo);//Calculates the distance between the two histograms        
        System.out.println(distanceX);

    }
}

