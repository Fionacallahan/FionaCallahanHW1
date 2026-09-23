import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        {
            //do not make longer than 10 lines 
            //scorecard: appendix B 
            //combos: appendix A

            //may want to use an ArrayList to store a hand
            System.out.println("Your first move of the game is rolling the dice: ");
            ArrayList <Die> hand = HandOfDie.createHand();
            HandOfDie.showHand(hand);

            Scanner input = new Scanner(System.in);

            System.out.println("Would you like to keep any of these dice? (y/n)");
            String userChoice = input.nextLine();

            Farkle.startGame(userChoice, hand);


    
            

            //int [] testHand = {1, 5, 5, 3, 4, 5};

            /**
             * 1. Create a hand of random 6 values 
             *      this is what it means when the player rolls 6 dice 
             * 2. show dice 
             * 3. did they score a farkle? 
             * 4. if no farkle: which dice to set aside? 
             * 5. once meld is done: show total score the player got 
             * 6. show dice used and unused 
             *
             * 3. 
             */


        }
    }
}
