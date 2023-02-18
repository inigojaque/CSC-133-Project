package org.csc133.a1;

import java.util.Random;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class RefuelingBlimps extends Fixed{
    private
    int capacity;
    int fuelLevel;
    public RefuelingBlimps(){
        Random rand = new Random();
        super.setSize(rand.nextInt(50 - 10 + 1) + 10);
        capacity = super.getSize();
        super.setLocation(new Point((rand.nextInt(1024 )),
                (rand.nextInt(768))));
        fuelLevel = super.getSize();
    }
    public RefuelingBlimps(double x, double y, int r, int g, int b){
        super(x, y, r, g, b);
        Random rand = new Random();
        super.setSize(rand.nextInt(50 - 10 + 1) + 10);
        capacity = super.getSize();
        super.setLocation(new Point((rand.nextInt(1024 )),
                (rand.nextInt(768))));
        super.setColor(r, g, b);
        fuelLevel = super.getSize();
    }

    public void refuel(){
        fuelLevel = 0;
        modifyColor(-1);
    }

    public int getFuelLevel(){
        return fuelLevel;
    }

    public int getFuelCapacity() {
        return capacity;
    }

    public void setFuelCapacity(int newCapacity){
        capacity = newCapacity;
    }
}
