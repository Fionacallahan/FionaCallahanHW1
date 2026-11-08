import java.util.ArrayList;

/**
 * 
 * Player: represents a player in the game. A player holds a name, their totalScore, their hand of die
 */
public class Player {
    private String name;
    private int totalScore;
    private ArrayList<Die> hand;

    /**
     * Since the Name is not static, this method is needed to access the variable across the program. 
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Since the Total Score is not static, this method is needed to access the variable across the program. 
     * @return int
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * Since the Hand variable is not static, this method is needed to access the variable across the program. 
     * @return ArrayList <Die>
     */
    public ArrayList<Die> getHand()
    {
        return hand;
    }

    /**
     * Sets the name variable to newName.  
     * @param newName
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * Sets the totalScore variable to score.  
     * @param score
     */
    public void setTotalScore(int score)
    {
        this.totalScore = score;
    }

    /**
     * Sets the hand variable to newHand
     * @param newHand
     */
    public void setHand(ArrayList<Die> newHand)
    {
        this.hand = newHand;
    }
    

}
