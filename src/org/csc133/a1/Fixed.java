package org.csc133.a1;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public abstract class Fixed extends GameObject{
    //private
    public Fixed(){

    }
    public Fixed(double x, double y, int r, int g, int b){
        super(x, y, r, g, b);
    }
    public void setLocationX(){
    }
    public void setLocationY(){

    }
    public void setLocation(double x, double y){
        if(super.getLocationX() == 0 && super.getLocationY() == 0)
            super.setLocation(new Point(x, y));
    }
    public void setColor(int c){
        if(super.getColor() == 0){
            super.setColor(c);
        }else{
            throw new UnsupportedOperationException("Location not able to be " +
                    "altered.");
        }
    }
}
