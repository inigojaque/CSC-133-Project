package org.csc133.a1;

import java.util.Random;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class SkyScraper extends Fixed{
    private
    int sequenceNumber = 0;
    int damageApplied = 30;
    Random rand = new Random();

    public SkyScraper(){
        sequenceNumber = 1;
        super.setSize(rand.nextInt(300));
        super.setLocation(new Point((rand.nextInt(1024 )),
                (rand.nextInt(768))));
    }

    public SkyScraper(int n, int size, double x,
                      double y, int r, int g, int b){
        super(x, y, r, g, b);
        super.setSize(rand.nextInt(300));
        sequenceNumber = n;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int applyDamage(){
        return damageApplied;
    }

    public int getSequenceNumber(){
        return sequenceNumber;
    }

    public String toString(){
        return super.toString() + "/nSequence Number: " + sequenceNumber;
    }
}
