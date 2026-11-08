/**
* This program allows the user to play a Farkle game implementation. 
* Each user can play a round of Farkle where they are prompted to roll the dice, 
* display their hand, and decide whether or not to move their dice to their meld. 
* The user can now reroll any unmelded dice, bank their dice, or quit on their turn.
* When the round ends, their final total score is then shown. 
* A special feature that has been added is detecting a "Hot Hand", where all 6 dice can be used towards their score. 
* Testing has not been added to this program yet
* CPSC 224-02 - MWF 10:10-11:00 
* Programming Assignment #2
* Sources to cite: GeeksforGeeks, W3Schools
* 
* @author Fiona Callahan
* @version v1.0 8/28/19
*/


import java.util.ArrayList;
import java.util.Scanner;
/**
 * Acts as the main class for this program. Includes the main method
 */
public class Farkle {
    /**
     * The main method. Creates a hand, and then shows the hand to the user. 
     * Starts the game and sends the user into other methods. Asks the user their name.
     * @param args
     */
    public static void main (String[] args) {
        {
            //make a banner 
            System.out.println("*********************************************");
            System.out.println("*        Zag Farkle by Fiona Callahan!      *");
            System.out.println("               Copyright: 2026               ");
            System.out.println("*********************************************");
            System.out.println("How many points would you like to play in this game? ");
            Scanner input = new Scanner(System.in);
            
            //Scanner points = new Scanner(System.in);
            String pointsAns = input.nextLine();

            int points;

            if (pointsAns.isEmpty())
            {
                points = 10000;

            }
            else{
                points = Integer.parseInt(pointsAns.trim());
            }

            System.out.println("You will be playing the game until " + points + " amount."); 

            //figure out number of players
            System.out.println("How many players are going to be playing? ");
            String playersPlaying = input.nextLine();

            int numPlayers;
            
            if (playersPlaying.isEmpty())
            {
                numPlayers = 1;
            }

            else{
                numPlayers = Integer.parseInt(playersPlaying.trim());
            }

            Player [] playerArray = new Player[numPlayers];

            System.out.println("This game will be played with " + numPlayers + " number of players.");
            // figure out how to iterate through every player: 
            String playerName;
            for (int i = 0; i < numPlayers; i++)
            {
                System.out.println("Welcome to Farkle! What is player " + (i + 1) + "'s name  ");
                //Scanner input = new Scanner(System.in);
                playerName = input.nextLine();

                if (playerName.isEmpty())
                {
                    playerArray[i] = new Player();
                    playerArray[i].setName("Unknown Player #" + (i + 1));
                    playerArray[i].setTotalScore(0);
                }
                else{
                    playerArray[i] = new Player();
                    playerArray[i].setName(playerName);
                    playerArray[i].setTotalScore(0);
                }
            }


            //VARIABLES: 
            //PlayerOne: player one name 
            //numPlayers: number of players playing 
            //points: number of points play to 



            //do not make longer than 10 lines 
            //scorecard: appendix B 
            //combos: appendix A
            //may want to use an ArrayList to store a hand


            System.out.println(playerArray[0].getName() + ": your first move of the game is rolling the dice: ");
            ArrayList <Die> hand = HandOfDie.createHand();
            playerArray[0].setHand(hand);
            HandOfDie.showHand(playerArray[0].getHand());

            PlayGame.startGame("y", playerArray[0].getHand(), points, playerArray[0], playerArray);
            //all other functions in different classes
        }



    }
}
