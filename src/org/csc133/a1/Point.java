package org.csc133.a1;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class Point {
    private
    double x = 0.0;
    double y = 0.0;

    public Point(){//Blank constructor

    }

    public Point(double x, double y){//Constructor w/ points
        this.x = x;
        this.y = y;
    }

    public double getX(){//Returns the x coordinate of point
        return x;
    }

    public void setX(double x){//Changes the x coordinate to passed value
        this.x = x;
    }

    public double getY(){//Returns the y coordinate of the point
        return y;
    }

    public void setY(double y){//Changes the y coordinate to passed value
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location: (" + x + ", " + y + ")" ;
    }
}
