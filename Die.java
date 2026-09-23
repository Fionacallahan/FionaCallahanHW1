import java.util.Random;

public class Die {
    int faceValue;

    public void roll(){
        Random randObject = new Random();
        int randInt = randObject.nextInt(6) + 1;
        this.faceValue = randInt; 
    }

    public int getFaceValue(){
        return faceValue;
    }

    public void setFaceValue(int value)
    {
        this.faceValue = value;
    }
}
