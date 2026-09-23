/**
* This program computes a Farkle game implementation. 
* CPSC 224-02 - MWF 10:10-11:00 
* Programming Assignment #1
* No sources to cite.
* 
* @author Fiona Callahan
* @version v1.0 8/28/19
*/
import java.util.ArrayList;
import java.util.Scanner;



public class Farkle{

    public static boolean check_saveable(ArrayList<Die> dieNumber, ArrayList <Die> saved, int index)
    {

        if (dieNumber.get(index).getFaceValue() == 5 || dieNumber.get(index).getFaceValue() == 1){
            return true;
        }
        for (int i = 0; i < 6; i++)
        {
            if (dieNumber.get(index).getFaceValue() == saved.get(i).getFaceValue()){
                return true;
            }
        }

        int same = 0;
        for (int i = 0; i < 6; i++)
        {
            if (dieNumber.get(index).getFaceValue() == dieNumber.get(i).getFaceValue())
            {
                same += 1;
            }
            if (same >= 3)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFarkle(ArrayList <Die> hand, ArrayList <Die> saved, int savedNumber)
    {
        // detect if there is a farkle thrown 
        // if not a farkle... which dice to add to meld?
        boolean farkle = true;
        for (int i = 0; i < 6; i ++)
        {
            if (check_saveable(hand, saved, i) && hand.get(i).getFaceValue() != -1)
            {
                farkle = false;
            }
        }
        if (farkle)
        {
            System.out.println("Farkle!! ");
            System.exit(0);
        }


        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to keep any of these dice? (y, n)");
        String userChoice = input.nextLine();

        if (userChoice.equals("y"))
        {
            int outindex = 0;
            boolean badMeld = false;
            if (hand.get(outindex).getFaceValue() == -1)
            {
                for (int y = outindex; y < 6; y ++)
                {
                    if (hand.get(y).getFaceValue() != -1)
                    {
                        outindex = y;
                        break;
                    }
                }
            }
            // FIX - if something 
            if (check_saveable(hand, saved, outindex))
            {
                saved.get(outindex).setFaceValue(hand.get(outindex).getFaceValue());
                hand.get(outindex).setFaceValue(-1);
                savedNumber += 1;
                farkle = false;
            }
            else{
                System.out.println("No possible meld for: " + hand.get(outindex).getFaceValue());
                badMeld = true;
            }

            outindex += 1;

            return badMeld;

        }
        return false;


        

    }

    public static void reRoll (ArrayList <Die> hand, ArrayList <Die> saved, int savedNumber)
    {
        boolean reroll = true;
        boolean bank = false;
        while (savedNumber < 6){
            Scanner input = new Scanner(System.in);

            System.out.println("Would you like to bank your score now? (y, n)");
            String userChoice = input.nextLine();

            if (userChoice.equals("y")){
                bank = true;
                break; 

            }
            else{
                System.out.println("Roll of the dice: ");
                if (reroll == true)
                {
                    HandOfDie.createHandReRoll(hand);
                    reroll = false;
                }
                for (int i = 0; i < hand.size(); i++)
                {
                    if (hand.get(i).getFaceValue() != -1)
                    {
                        System.out.println(hand.get(i).getFaceValue());
                    }
                }
                System.out.println("");

                boolean change = checkFarkle(hand, saved, savedNumber);
                reroll = !change;

            }

        }
        if (bank)
        {
            Scorecard.checkScoreCard(saved);
        }
    }


    public static void startGame(String choice, ArrayList<Die> hand)
    {
        if (choice.equals("y")){
            int savedNumber = 0;
            ArrayList <Die> saved = new ArrayList<>();
            for (int i = 0; i < 6; i ++)
            {
                Die die = new Die();
                die.setFaceValue(-1);
                saved.add(die);
            }
            for (int i = 0; i < hand.size(); i ++){
                if (check_saveable(hand, saved, i) == true)
                {
                    //GET :: 
                    saved.get(i).setFaceValue(hand.get(i).getFaceValue());
                    hand.get(i).setFaceValue(-1);
                    savedNumber += 1;

                }
                else{
                    System.out.println("No possible meld for ");
                    HandOfDie.showHand(hand);
                }
            }

            reRoll(hand, saved, savedNumber);
        }
        else{
            ///SOMETHING HERE 
        }
    }

}