// needed for doing graphics
import java.awt.*;
import javax.swing.*;

/**
 * Class Logo - A program that asks the user for a few inputs to generate a simple logo that cannot be copyrighted by a big corporation.
 * 
 * @author Comingupwithnames
 * @version Feb 18, 2021
 * 
 * --------------------------
 * CS203
 * Starter Code Last Updated:  Summer 2019
 * --------------------------
 * Known defficiencies: Any longs or doubles will make the program refuse to work since it only expects integers.
 */

public class Logo extends JPanel
{
    // instance variables
    int numClouds = 5;
    int numNuggets = 2;
    String nuggetColor = "brown";

    public static void main(String[] args)
    {
        //Create a window frame
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500,667);

        // put the picture in the frame
        Logo logo = new Logo();
        logo.init();
        myFrame.add(logo);

        //show the user
        myFrame.setVisible(true);
        System.out.println("Here is your simple yet unique logo!");
    }

    //Method that prompts user for multiple inputs and checks if the inputs are the ones wanted
    public void init() 
    {   
        //Greets the user
        String greeting = "Welcome to the program of drawing cool logos!";
        JOptionPane.showMessageDialog(null,greeting);

        //Promps user to input number of clouds in logo
        String question2 = "How many clouds do you want in the logo?";
        String numCloudsString = JOptionPane.showInputDialog(question2);
        numCloudsString = numCloudsString.trim(); //Trims just in case extra spaces are added
        numClouds = Integer.parseInt(numCloudsString);
        if(numClouds>5 || numClouds <= 0)
        {
            String errorClouds = "There are too many or too little clouds!";
            JOptionPane.showMessageDialog(null,errorClouds);    
        }

        //Asks the user for number of chicken nuggets as well as the color for said nuggets
        String question3 = "How many chicken nuggets do you want in the logo?";
        String numNuggetsString = JOptionPane.showInputDialog(question3);
        numNuggetsString = numNuggetsString.trim(); //Trims just in case extra spaces are added
        numNuggets = Integer.parseInt(numNuggetsString);
        if(numNuggets>2 || numClouds <= 0)
        {
            String errorNuggets = "There are too many or too little nuggets!";
            JOptionPane.showMessageDialog(null,errorNuggets);    
        }
        if (numNuggets<=2 || numClouds > 0) //Checks to see if input is either 2 or 1
        {
            String question4 = "What color do you want your nuggets to be?";
            String nuggetColorString = JOptionPane.showInputDialog(question4);
            nuggetColorString = nuggetColorString.trim(); //Trims just in case extra spaces are added
            nuggetColor = nuggetColorString.toLowerCase();
            if(nuggetColor.contains("brown")) //Something like green nuggets would look spoiled and the logo would be ruined
            {
                String goodNuggetColor = "Good choice.";
                JOptionPane.showMessageDialog(null,goodNuggetColor);     
            }
            else
            {
                String errorNuggetColor = "Invalid color, using brown instead, anything else would make them nasty.";
                JOptionPane.showMessageDialog(null,errorNuggetColor);    
            }
        }

    }
    //Paints what the user inputs in the dialogue boxes
    //Graphics g is used for getting colors and using them to paint
    public void paint(Graphics g) { 
        super.paint(g);
        setBackground(Color.red); //Sets Background color

        //Draws a yellow M
        g.setColor(Color.yellow);
        g.drawLine(100,200,100,500);
        g.drawLine(100,200,250,500);
        g.drawLine(250,500,400,200);
        g.drawLine(400,200,400,500);

        //Draws text under the M
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,24));
        g.drawString("Yum!",220,524);
        g.drawString("Quasi Mcdonald's Logo!",120,550);

        //Switch statement to check for number of clouds in the input
        switch(numClouds)
        {
            case 1:
            drawCloud(g, 250, 30);
            break;

            case 2:
            drawCloud(g, 100, 20);
            drawCloud(g, 400, 20);
            break;

            case 3:
            drawCloud(g, 125, 20);
            drawCloud(g, 250, 10);
            drawCloud(g, 375, 20);
            break;

            case 4:
            drawCloud(g, 50, 20);
            drawCloud(g, 150, 10);
            drawCloud(g, 250, 20);
            drawCloud(g, 350, 10);
            break;

            case 5:
            drawCloud(g, 100, 20);
            drawCloud(g, 200, 10);
            drawCloud(g, 250, 20);
            drawCloud(g, 300, 10);
            drawCloud(g, 400, 20);
            break;

            default:
            break;
        }

        //Draws the number of nuggets inputted
        switch(numNuggets)
        {
            case 1:
            drawNugget(g,10,450);
            break;

            case 2:
            drawNugget(g,10,450);
            drawNugget(g,410,450);
            break;

            default:
            break;
        }

    }  

    //Draws a set of white circles/ovals to create a simple cloud
    //Integers x and y move the simple drawing around the canvas
    //Graphics g is used for getting colors and using them to paint
    public void drawCloud(Graphics g, int x, int y)
    {
        // simple cloud
        g.setColor(Color.WHITE);
        g.fillOval(x+0,y+0,50,50); //Each oval is a part of the entire cloud
        g.fillOval(x+5,y+5,50,50);
        g.fillOval(x+10,y+0,40,30);
        g.fillOval(x-10,y+10,50,60);
        g.fillOval(x-5,y-10,45,55);
        g.fillOval(x+5,y+15,50,50);
    }

    //Draws two ovals to create a simple boot nugget
    //Integers x and y move the simple drawing around the canvas
    //Graphics g is used for getting colors and using them to paint
    public void drawNugget(Graphics g, int x, int y)
    {
        //Simple attempt at a boot nugget.
        Color lightBrown = new Color(249, 176, 66);
        g.setColor(lightBrown);
        g.fillOval(x+0,y+0,50,100);
        g.fillOval(x+5,y-10,65,50);
    }
}