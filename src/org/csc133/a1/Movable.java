package org.csc133.a1;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public abstract class Movable extends GameObject implements ISteerable{
    private
    int heading = 0;
    int speed = 0;
    boolean steerable;

    public Movable(){

    }

    public Movable( double x, double y, int r, int g, int b){
        super(x, y, r, g, b);
    }

    public int getHeading(){
        return heading;
    }

    public void setHeading(int newHeading){
        if(newHeading >= 0 && newHeading < 360) {
            heading = newHeading;
        }else{
            throw new IndexOutOfBoundsException("Invalid heading passed");
        }
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }

    public void move(){
        Point newLocation = calcNewLocation();
        super.setLocation(newLocation);
    }

    public void setSteerable(boolean s){
        steerable = s;
    }

    public boolean isSteerable(Movable obj){
        if(steerable == true)
            return true;
        return false;
    }

    private Point calcNewLocation(){
        checkLocation();
        double theta = 90 - heading;
        double deltaX = Math.cos(Math.toRadians(theta)) * speed;
        double deltaY = Math.sin(Math.toRadians(theta)) * speed;
        Point newLocation = new Point(super.getLocationX() + deltaX,
                                      super.getLocationY() + deltaY);
        return newLocation;
    }

    private void checkLocation(){
        //Turn around if hitting top left corner
        if (super.getLocationX() == 0 && super.getLocationY() == 0) {
            if (this.heading > 90) {
                this.heading = 45;
            }
        }
        //Turn around if hitting top left corner
        else if (super.getLocationX() <= 0
                && super.getLocationY() >= 768) {
            if (this.heading > 180 || this.heading < 90) {
                this.heading = 135;
            }
        }
        //Turn around if hitting bottom right corner
        else if (super.getLocationX() >= 1024 && super.getLocationY() <= 0) {
            if (this.heading < 270 && this.heading > 0) {
                this.heading = 315;
            }
        }
        //Turn around if hitting top right corner
        else if (super.getLocationX() >= 1024 && super.getLocationY() >= 768) {
            if (this.heading > 270 || this.heading < 180) {
                this.heading = 225;
            }
        }
        //Turn around if hitting left wall
        else if (super.getLocationX() <= 0){
            this.heading = 90;
        }
        // Turn around if hitting bottom wall
        else if (super.getLocationY() <= 0){
            this.heading = 0;
        }
        //Turn around if hitting right wall
        else if (super.getLocationX() >= 1024){
            this.heading = 270;
        }
        //Turn around if hitting top wall
        else if (super.getLocationY() >= 768){
            this.heading = 180;
        }
    }

    public abstract void increaseDamageLevel(int damage);
}
