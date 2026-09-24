import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * HandOfDie: methods in this class are used mainly when creating new ArrayLists.
 */
public class HandOfDie { 
    //functions: 
    // Roll dice - in die class
    // show hand

    /**
     * Creates a hand of six Die. Sorts the Die in the appropriate order 
     * @return ArrayList <Die>
     */
    public static ArrayList <Die> createHand()
    {
        Die myDie;
        ArrayList<Die> hand = new ArrayList<>();
        for (int i = 0; i < 6; i++)
        {
            myDie = new Die();
            myDie.roll();
            hand.add(myDie);
        }
        //how to sort an ArrayList by a specific variable: (GeeksforGeeks)
        hand.sort(Comparator.comparing(Die::getFaceValue));
        return hand;
    }

    /**
     * throughout the program, the user will be able to show their hand and see what Die 
     * they ended up rolling. 
     * @param list
     */
    public static void showHand(ArrayList<Die> list){ 
        System.out.println("Your current roll is: ");
        System.out.println("---------------------------");
        for (int i = 0; i < list.size(); i++){
            Die chosenDie = list.get(i);
            System.out.print(chosenDie.getFaceValue() + " || "); //getting the actual value: use this in rest of program
        }
        System.out.println();
    }


}