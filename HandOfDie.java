import java.util.ArrayList;

public class HandOfDie { 
    //functions: 
    // Roll dice - in die class
    // show hand
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
        return hand;
    }

    public static void createHandReRoll(ArrayList <Die> hand)
    {
        Die myDie;
        for (int i = 0; i < 6; i++)
        {
            myDie = new Die();
            myDie.roll();
            int faceValue = myDie.getFaceValue();
            if (hand.get(i).getFaceValue() != -1)
            {
                hand.get(i).setFaceValue(faceValue);
            }
        }
    }


    public static void showHand(ArrayList<Die> list){
        ///FIX  : currently getting the actual die 
        System.out.println("Your current roll is: ");
        System.out.println("---------------------------");
        for (int i = 0; i < list.size(); i++){
            Die chosenDie = list.get(i);
            System.out.print(chosenDie.getFaceValue() + " || ");
        }
        System.out.println();
    }


}