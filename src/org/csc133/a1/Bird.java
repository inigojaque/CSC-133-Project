package org.csc133.a1;

import java.util.Random;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class Bird extends Movable{
    private
    int damageApplied = 20;
    int maxDamageLevel = 40;
    int damageLevel;
    Random rand = new Random();

    public Bird(){
        super.setHeading(rand.nextInt(360));
        super.setSpeed(rand.nextInt(10 - 5 + 1) + 5);
        super.setSteerable(false);
        super.setSize(rand.nextInt(50 - 10 + 1) + 10);
        super.setLocation(new Point(rand.nextInt(1023),
                rand.nextInt(767)));
    }

    public Bird(double x, double y, int r, int g, int b){
        super(x, y, r, g, b);
        super.setSize(rand.nextInt(50 - 10 + 1) + 10);
        super.setHeading(rand.nextInt(359));
        super.setSpeed(rand.nextInt(10 - 5 + 1) + 5);
        super.setSteerable(false);
        super.setColor(r, g, b);
    }

    public void setColor(){

    }

    public void move(){
        super.move();
        Random rand = new Random(1);
        if(rand.nextInt() == 1){
            if(super.getHeading() + 5 < 360)
                super.setHeading(super.getHeading() + 5);
        }else{
            if(super.getHeading() - 5 > 0)
                super.setHeading(super.getHeading() - 5);
        }
    }

    public void increaseDamageLevel(int damage){
        damageLevel += damage;
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public int applyDamage() {
        return damageApplied;
    }

    public void steer(int x){}
}
