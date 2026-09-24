/**
* This program allows the user to play a Farkle game implementation. 
* Each user can play a round of Farkle where they are prompted to roll the dice, 
* display their hand, and decide whether or not to move their dice to their meld. 
* The round ends when they bank their dice, and their final total score is then shown. 
* CPSC 224-02 - MWF 10:10-11:00 
* Programming Assignment #1
* Sources to cite: GeeksforGeeks, W3Schools
* 
* @author Fiona Callahan
* @version v1.0 8/28/19
*/



import java.util.ArrayList;
/**
 * Acts as the main class for this program. Includes the main method
 */
public class Farkle {
    /**
     * The main method. Creates a hand, and then shows the hand to the user. 
     * Starts the game and sends the user into other methods. 
     * @param args
     */
    public static void main (String[] args) {
        {
            //do not make longer than 10 lines 
            //scorecard: appendix B 
            //combos: appendix A
            //may want to use an ArrayList to store a hand
            System.out.println("Your first move of the game is rolling the dice: ");
            ArrayList <Die> hand = HandOfDie.createHand();
            HandOfDie.showHand(hand);

            PlayGame.startGame("y", hand);
            //all other functions in different classes
        }



    }
}
