package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class GameObject {
    private
    int size = 0;
    int color = 0;
    int colorR = 0;
    int colorG = 0;
    int colorB = 0;
    int colorChange = 25;
    Point location;
    public GameObject(){

    }
    public GameObject( double x, double y, int r, int g, int b){
        if((x > 0.0 && x < 1024.0) && (y > 0 && y < 768.0)) {
            location = new Point(x, y);
        }
        //ColorUtil test = new ColorUtil();
        color = ColorUtil.rgb(r, g, b);
        colorR = ColorUtil.red(color);
        colorG = ColorUtil.green(color);
        colorB = ColorUtil.blue(color);
    }

    public int getSize(){
        return size;
    }

    public void setSize(int newSize){
        if(newSize > 0 && newSize < 50)
            size = newSize;
    }

    public Point getLocation(){
        return location;
    }

    public double getLocationX(){
        return location.getX();
    }

    public double getLocationY(){
        return location.getY();
    }

    public void setLocationX(double x){
        location.setX(x);
    }

    public void setLocationY(double y){
        location.setX(y);
    }

    public void setLocation(Point newLocation){
        if((newLocation.getX() > 0.0 && newLocation.getX() < 1024.0)
            && (newLocation.getY() > 0.0 && newLocation.getY() < 768.0)) {
            location = newLocation;
        }else{
            throw new IndexOutOfBoundsException("Invalid Location passed");
        }
    }

    public int getColor(){
        return color;
    }
    public int getColorR(){
        return colorR;
    }
    public int getColorG(){
        return colorG;
    }
    public int getColorB(){
        return colorB;
    }

    public void setColor(int newR, int newG, int newB){
        color = ColorUtil.rgb(newR, newG, newB);
        colorR = ColorUtil.red(color);
        colorG = ColorUtil.green(color);
        colorB = ColorUtil.blue(color);
    }
    public void setColor(int color){
        this.color = color;
        colorR = ColorUtil.red(color);
        colorG = ColorUtil.green(color);
        colorB = ColorUtil.blue(color);
    }

    public void modifyColor(int plusOrMinus){
        if(plusOrMinus == 1){
            color = ColorUtil.rgb(colorR + colorChange,
                    colorG + colorChange,
                    colorB + colorChange);
        }else if (plusOrMinus == -1){
            color = ColorUtil.rgb(colorR - colorChange,
                    colorG - colorChange,
                    colorB - colorChange);
        }

    }

    public String toString(){
        return "Size: " + size + "/nColor: " + color +"/n"
                + location.toString();
    }

}
