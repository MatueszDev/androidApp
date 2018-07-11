package com.nokia.soccer.soccerapp;

import org.junit.Assert;
import org.junit.Test;

public class FairPlayTest{

    @Test
    public void ifOneYellow_thenOnePoint(){
        int points = FairPlayPointsCalucator.calculatePoints("Kane,yellow");
        Assert.assertEquals(1, points);
    }

    @Test
    public void ifSecondYellowForSamePlayer_thenThreePoints(){
        int points = FairPlayPointsCalucator.calculatePoints("Kane,yellow,Kane,yellow");
        Assert.assertEquals(3, points);
    }

    @Test
    public void ifStraightRed_thenFourPoints(){
        int points = FairPlayPointsCalucator.calculatePoints("Kane," + FairPlayPointsCalucator.RED );
        Assert.assertEquals(4, points);
    }

    @Test
    public void ifYellowAndRed_thenFivePoints(){
        int points = FairPlayPointsCalucator.calculatePoints("Kane,yellow,Kane," + FairPlayPointsCalucator.RED );
        Assert.assertEquals(5, points);
    }

    @Test
    public void russianFairPlayPoints(){
        int points = FairPlayPointsCalucator.calculatePoints("Smolnikov,yellow,Smolnikov,yellow,Gazinsky,yellow");
        points += FairPlayPointsCalucator.calculatePoints("Fydor,yellow");
        points += FairPlayPointsCalucator.calculatePoints("Golovin,yellow");
        Assert.assertEquals(6, points);
    }

}
