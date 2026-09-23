import java.util.ArrayList;

public class Scorecard {
    public static void checkScoreCard(ArrayList <Die> saved)
    {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        for (int i = 0; i < 6; i++)
        {
            if (saved.get(i).getFaceValue() == 1)
            {
                ones += 1;
            }
            else if (saved.get(i).getFaceValue() == 2)
            {
                twos += 1;
            }
            else if (saved.get(i).getFaceValue() == 3)
            {
                threes += 1;
            }
            else if (saved.get(i).getFaceValue() == 4)
            {
                fours += 1;
            }
            else if (saved.get(i).getFaceValue() == 5)
            {
                fives += 1;
            }
            if (saved.get(i).getFaceValue() == 6)
            {
                sixes += 1;
            }
        }

        int totalscore = 0;

        //copied from code: the scorecard 

        if (ones == 3) {
            totalscore += 1000;
        }
        if (twos == 3) {
            totalscore += 200;
        }
        if (threes == 3) {
            totalscore += 300;
        }
        if (fours == 3) {
            totalscore += 400;
        }
        if (fives == 3) {
            totalscore += 500;
        }
        if (sixes == 3) {
            totalscore += 600;
        }

        //four of a kind
        if (ones == 4 || twos == 4 || threes == 4 || fours == 4 || fives == 4 || sixes == 4) {
            totalscore += 1000;
        }

        //five of a kind
        if (ones == 5 || twos == 5 || threes == 5 || fours == 5 || fives == 5 || sixes == 5) {
            totalscore += 2000;
        }

        //six of a kind
        if (ones == 6 || twos == 6 || threes == 6 || fours == 6 || fives == 6 || sixes == 6) {
            totalscore += 3000;
        }

        // 4 of a kind 3 pair
        if ((ones == 4 && (twos == 2 || threes == 2 || fours == 2 || fives == 2 || sixes == 6)) ||
            (twos == 4 && (ones == 2 || threes == 2 || fours == 2 || fives == 2 || sixes == 6)) ||
            (threes == 4 && (ones == 2 || twos == 2 || fours == 2 || fives == 2 || sixes == 6)) ||
            (fours == 4 && (ones == 2 || twos == 2 || threes == 2 || fives == 2 || sixes == 6)) ||
            (fives == 4 && (ones == 2 || twos == 2 || threes == 2 || fours == 2 || sixes == 6)) ||
            (sixes == 4 && (ones == 2 || twos == 2 || threes == 2 || fours == 2 || fives == 2))) {
            totalscore += 1500;
        } // i wouldnt put this in your code...

        // run
        if (ones == 1 && twos == 1 && threes == 1 && fours == 1 && fives == 1 && sixes == 1) {
            totalscore += 2500;
        }

        totalscore += 50 * fives;
        totalscore += 100 * ones;

        System.out.println("Your total score in this game is: " + totalscore);
        System.out.println("GOOD WORK!! ");







    }
}
