import java.util.ArrayList;

/**
 * 
 * Scorecard: deals with all scoring methods 
 */
public class Scorecard {


    /**
     * Checks if there is a Straight shown in the dice, but also it checks for triples, pairs, and other points 
     * that could be acquired from ones or fives. 
     * @param meldScore
     * @param meldDiceSizesCount
     * @return int 
     */
    public static int checkStraight(int meldScore, int [] meldDiceSizesCount)
    {
        boolean isStraight = true;
        for (int i = 0; i < 6; i++)
        {
            if (meldDiceSizesCount[i] != 1)
            {
                isStraight = false;
            }
        }

        if (isStraight)
        {
            meldScore += 1000;
        }
        else{
            //check pairs 
            int pairCount = 0;
            for (int i = 0; i < 6; i ++)
            {
                if (meldDiceSizesCount[i] == 2)
                {
                    pairCount += 1;
                }
            }

            if (pairCount == 3)
            {
                meldScore += 750;
            }
            else{
                //check triples
                boolean isTripleSet = false;
                for( int i = 0; i < 6; i++ ) {
                    if(meldDiceSizesCount[i] >= 3 ) {
                        // Found triple (or more!)
                        isTripleSet = true;
                        int tripleSetPoints = 0;
                        if(i == 1) {
                            tripleSetPoints = 1000;
                        } else {
                            tripleSetPoints = i * 100;
                        }
                        if(meldDiceSizesCount[i] > 3 ) { // 4 + in set
                            tripleSetPoints += (meldDiceSizesCount[i] - 3) * 100 * i;
                        }
                        meldScore += tripleSetPoints;
                    }
                }

                // Add 1's & 5's if unused
                if(meldDiceSizesCount[1] < 3) {
                    meldScore += meldDiceSizesCount[1] * 100;
                }

                if(meldDiceSizesCount[5] < 3) {
                    meldScore += meldDiceSizesCount[5] * 50;
                }
            }
        }
        return meldScore;
    }

    /**
     * The user interface portion that portrays what dice the user has and what they can move into the meld. 
     * @param hand
     * @param meld
     * @param done
     * @return boolean
     */

    public static boolean printStatus(ArrayList <Die> hand, ArrayList <Die> meld, boolean done)
    {
        System.out.println();
        System.out.println("*************************** Current hand and meld *******************");
        System.out.println(" Die   Hand |   Meld");
        System.out.println("------------+---------------");
        for (int i = 0; i < 6; i++)
        {
            //casting
            char option = (char) ('A' + i);
            System.out.print(" (" + option + ")   ");

            //HAND 
            if (hand.get(i).getFaceValue() != 0)
            {
                System.out.println(hand.get(i).getFaceValue());
            }
            else{
                System.out.print(" ");
            }

            System.out.print("  |     ");

            //MELD 
            if (meld.get(i).getFaceValue() != 0)
            {
                System.out.print(meld.get(i).getFaceValue());
            }
            else{
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println("----------------------------------");
        return done;
    }
}
