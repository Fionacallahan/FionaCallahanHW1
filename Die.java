import java.util.Random;

/**
 * Die: represents what is being held in the Hand ArrayList of Die. 
 */
public class Die {
    int faceValue;

    /**
     * The roll class randomly chooses a number between one and six and assigns
     * the die's face value this number
     * 
     */
    public void roll(){
        Random randObject = new Random();
        int randInt = randObject.nextInt(6) + 1;
        this.faceValue = randInt; 
    }

    /**
     * Since the faceValue is not static, this method is needed to access the variable across the program. 
     * @return int
     */
    public int getFaceValue(){
        return faceValue;
    }

    /**
     * Since the faceValue variable is not static, this method is in place to change faceValue when 
     * not in this Die class. It sets the faceValue to value. 
     * @param value
     */
    public void setFaceValue(int value)
    {
        this.faceValue = value;
    }
}
