import java.util.ArrayList;

/**
 * 
 * Player: represents a player in the game. A player holds a name, their totalScore, their hand of die
 */
public class Player {
    private String name;
    private int totalScore;
    private ArrayList<Die> hand;

    public String getName()
    {
        return name;
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    public ArrayList<Die> getHand()
    {
        return hand;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setTotalScore(int score)
    {
        this.totalScore = score;
    }

    public void setHand(ArrayList<Die> newHand)
    {
        this.hand = newHand;
    }
    

}
