import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * PlayGame: the Class that the game "runs" out of. It checks for Farkles, but most importantly,
 * starts the game. This is the "round" per say. 
 */
public class PlayGame{

    /**
     * checkFarkle() detects if there is a farkle thrown at first. If not, it moves on to find pair counts, or straights. 
     * The user interface here is easy to follow, as it allows the user to add any dice in the "roll" category into the meld category 
     * where they cannot move it untilt the end when a new turn persists. 
     * @param hand
     * @param saved
     * @param savedNumber
     * @return boolean
     */
    public static boolean checkFarkle(ArrayList <Die> hand, ArrayList <Die> saved, int savedNumber)
    {
        // detect if there is a farkle thrown 
        // if not a farkle... which dice to add to meld?
        boolean farkle = true;
        if (saved.get(1).getFaceValue() != 0 || saved.get(5).getFaceValue() != 0 )
        {
            farkle = false;
        }

        for (int i = 2; i < 7; i++)
        {
            if (saved.get(i).getFaceValue() >= 3)
            {
                farkle = false;
            }
        }

        int pairCount = 0;
        boolean done = false;
        for (int i = 1; i < 7; i++)
        {
            if (saved.get(i).getFaceValue() == 2)
            {
                pairCount += 1;
            }
        }
        if (pairCount == 3)
        {
            farkle = false;
        }

        int totalScore = 0;
        if (farkle)
        {
            System.out.println("FARKLE! Points: 0");
        }
        else{
            String futureUserInput;
            int meldScore = 0;
            ArrayList <Die> meld = new ArrayList<>();
            for (int i = 0; i < 6; i ++)
            {
                Die newDieSet = new Die();
                newDieSet.setFaceValue(0);
                meld.add(newDieSet);
            }

            while (!done)
            {
                //PRINT STATUS
                Scorecard.printStatus(hand, meld, done);
                boolean isValidMeld = false;
                meldScore = 0;

                // creating a meldDiceCount
                int meldDiceCount = 0;
                ArrayList <Integer> meldDice = new ArrayList<>();
                for (int i = 0; i < 6; i ++)
                {
                    if (meld.get(i).getFaceValue() != 0)
                    {
                        meldDice.add(meld.get(i).getFaceValue());
                        meldDiceCount += 1;
                    }
                }


                //creating a meldDiceSizesCount
                int [] meldDiceSizesCount = new int[7];
                for (int i = 0; i < meldDice.size(); i++)
                {
                    meldDiceSizesCount[meldDice.get(i)] += 1;
                }
                

                //check straight: 

                meldScore += Scorecard.checkStraight(meldScore, meldDiceSizesCount);
                System.out.println("                Meld Score: " + meldScore);
                System.out.println();

                System.out.println(" (K) BanK Meld & End Round");
                System.out.println(" (Q) Quit game");
                System.out.println();
                System.out.print("Enter letters for your choice(s): ");
                Scanner input = new Scanner(System.in);
                futureUserInput = input.nextLine();

                for (int i = 0; i < futureUserInput.length(); i++)
                {
                    char letter = Character.toUpperCase(futureUserInput.charAt(i));

                    if (letter >= 'A' && letter <= 'F')
                    {
                        int index = letter - 'A';

                        if (hand.get(index).getFaceValue() != 0)
                        {
                            meld.get(index).setFaceValue(hand.get(index).getFaceValue());
                            hand.get(index).setFaceValue(0);
                        }
                        else{
                            hand.get(index).setFaceValue(meld.get(index).getFaceValue());
                            meld.get(index).setFaceValue(0);
                        }

                    }
                    else if (letter == 'Q')
                    {
                        done = true;
                    }
                    else if (letter == 'K')
                    {
                        done = true;
                        totalScore += meldScore;
                    }
                }
                System.out.println();
                System.out.println("Round Over. total score is now: " + totalScore);
                System.out.println();
        
            }
        }
        //WHY 
        return done;
    }

    /**
     * startGame ensures that the user decided to play. It then creates an ArrayList storing the number of times each value shows up. 
     * It prints out this quantity, and then moves onto the Farkle play. 
     * @param choice
     * @param hand
     */

    public static void startGame(String choice, ArrayList<Die> hand)
    {
        //double check
        if (choice.equals("y")){
            int savedNumber = 0;

            //creating a new array to compare the dice Number costs 
            ArrayList <Die> saved = new ArrayList<>();
            for (int i = 0; i < 7; i++)
            {
                Die newDieSaved = new Die();
                newDieSaved.setFaceValue(0);
                saved.add(newDieSaved);
            }
            int current;
            for (int i = 0; i < 6; i++)
            {
                current = saved.get(hand.get(i).getFaceValue()).getFaceValue();
                saved.get(hand.get(i).getFaceValue()).setFaceValue(current + 1);
    
            }

            System.out.println("Quantity of each die value: ");
            for (int i = 1; i < 7; i++)
            {
                System.out.print(saved.get(i).getFaceValue() + " || ");
            }


            checkFarkle(hand, saved, savedNumber);
    }

}}