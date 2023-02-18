package org.csc133.a1;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class Helicopter extends Movable{

    private
    int stickAngle = 0;
    int maximumSpeed = 45;
    int fuelLevel = 100;
    int fuelConsumptionRate = 5;
    int maxDamageLevel = 100;
    int damageLevel = 0;
    int damageApplied = 40;
    int lastSkyScraperReached = 0;
    int fuelCapacity = 100;

    public Helicopter(){
        super.setSteerable(true);
        super.setSpeed(maximumSpeed /2);
    }
    public Helicopter(int size, double x,
                      double y, int r, int g, int b){
        super(x, y, r, g, b);
        super.setSize(size);
        super.setSteerable(true);
        super.setSpeed(maximumSpeed/2);

    }

    public void increaseDamageLevel(int damage){
        if(damage > 0) {
            damageLevel += damage;
            maximumSpeed /= damageLevel;
        }
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public void resetDamageLevel(){
        damageLevel = 0;
    }

    public int getMaxDamageLevel(){
        return maxDamageLevel;
    }

    public int applyDamage() {
        return damageApplied;
    }

    public int getStickAngle(){
        return stickAngle;
    }

    public int getMaxSpeed(){
        return maximumSpeed;
    }

    public void setLastSkyScraperReached(int sequenceNumber){
        lastSkyScraperReached = sequenceNumber;
    }

    public int getLastSkyScraperReached() {
        return lastSkyScraperReached;
    }

    public void reduceFuelLevel(){
        fuelLevel -= fuelConsumptionRate;
    }

    public void increaseFuelLevel(int refuel){
        fuelLevel += refuel;
    }

    public int getFuelLevel(){
        return fuelLevel;
    }

    public void steer(int stickAngleChange) {
        stickAngle = stickAngleChange;
        if (fuelLevel > 0 && damageLevel < maxDamageLevel) {
            int update = super.getHeading();
            if (stickAngleChange < -40) {
                update += -40;
                //if(update < 0)
                //update += 360;
            } else if (stickAngleChange > 40) {
                update += 40;
                //if(update > 360)
                //update -= 360;
            } else {
                update += stickAngle;
            }
            if ((update += stickAngleChange) < 0) {
                update += 360;
            } else if(update > 360) {
                update -= 360;
            }
            super.setHeading(update);
        }
    }

    public void move(){
        super.move();
        reduceFuelLevel();
    }
}
