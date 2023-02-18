package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

import java.util.ArrayList;
import java.util.Random;

/* Author: Inigo Jaque
*  Class: CSC 133 Section 05
*  Project: SkyMail3000 Part 1
*  Last Updated: 3/5/2020
* */

public class GameWorld {

    private
    //Stores created set of GameObjects
    ArrayList<GameObject> list = new ArrayList<>();
    //Stores all movable objects
    ArrayList<Movable> movableObjects = new ArrayList<>();
    Helicopter playerHelicopter = null;
    Random randomColorGen = new Random();
    int birdColor = -1;
    int skyScraperColor = -1;
    int refuelingBlimpsColor = -1;
    int helicopterColor = -1;
    int currSequenceNumber = 0;
    int timePassed;
    int playerLives;
    int storedLeftMoves = 0;
    int storedRightMoves = 0;
    boolean gameOver;
    boolean exitConfirm = false;


    //Initializes fields and objects
    public void init(){
        timePassed = 0;
        playerLives = 3;
        gameOver = false;
        createPlayerHelicopter();
        createBird(3);
        createSkyScraper(4);
        createRefuelingBlimps(2);
    }

    //Makes a 'Bird' Movable GameObject with a randomly generated color
    public void createBird(int amt){
        for(int i = 0; i < amt; i++){
            Bird bird = new Bird();
            if(birdColor == -1) {
                bird.setColor(randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255));
                birdColor = bird.getColor();
            }else{
                bird.setColor(birdColor);
            }
            list.add(bird);
            movableObjects.add(bird);
        }
    }

    //Makes a 'SkyScraper' Fixed GameObject with a randomly generated color
    public void createSkyScraper(int amt){
        for(int i = 0; i < amt; i++){
            SkyScraper ss = new SkyScraper();
            if(skyScraperColor == -1) {
                ss.setColor(randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255));
                skyScraperColor = ss.getColor();
            }else{
                ss.setColor(skyScraperColor);
            }
            ss.setSequenceNumber(currSequenceNumber + 1);
            currSequenceNumber++;
            list.add(ss);
        }
    }

    //Makes a Refueling Blimp that can refuel Helicopters
    public void createRefuelingBlimps(int amt){
        for(int i = 0; i < amt; i++){
            RefuelingBlimps blimp = new RefuelingBlimps();
            if(refuelingBlimpsColor == -1){
                blimp.setColor(randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255));
                refuelingBlimpsColor = blimp.getColor();
            }else{
                blimp.setColor(refuelingBlimpsColor);
            }
            list.add(blimp);
        }
    }

    //Creates the Helicopter operated by the player
    public void createPlayerHelicopter(){
        playerHelicopter = new Helicopter( 10, 10.0, 10.0,
                                                4, 0, 0);
        list.add(playerHelicopter);
        movableObjects.add(playerHelicopter);
    }

    //Creates a helicopter that is not operated by the player
    public void createHelicopter(int amt){
        for(int i = 0; i < amt; i++){
            Helicopter heli = new Helicopter();
            if(helicopterColor == -1){
                heli.setColor(randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255),
                        randomColorGen.nextInt(255));
                refuelingBlimpsColor = heli.getColor();
            }else{
                heli.setColor(refuelingBlimpsColor);
            }
            list.add(heli);
            movableObjects.add(heli);
        }

    }

    //Increases the speed of the player's helicopter
    public void accelerate(){
        if(playerHelicopter != null){
            if(playerHelicopter.getSpeed() + 1
                    < playerHelicopter.getMaxSpeed())
            playerHelicopter.setSpeed(playerHelicopter.getSpeed() + 1);
        }else{
            System.err.println("Player Helicopter does not exist");
        }
    }

    //Decreases the speed of the player's helicopter
    public void brake(){
        if(playerHelicopter != null){
            if(playerHelicopter.getSpeed() - 1 > 0)
            playerHelicopter.setSpeed(playerHelicopter.getSpeed() - 1);
        }else{
            System.err.println("Player Helicopter does not exist");
        }
    }

    //Makes a request for the player's helicopter to move left
    public void playerHelicopterLeft(){
        if(playerHelicopter != null){
            storedLeftMoves++;
        }else{
            System.out.println("Player Helicopter does not exist");
        }
    }

    //Makes a request for the player's helicopter to move right
    public void playerHelicopterRight(){
        if(playerHelicopter != null){
            storedRightMoves++;
        }else{
            System.out.println("Player Helicopter does not exist");
        }
    }

    //Decreases the lives of the player by one
    public void reduceLives(){
        playerLives--;
        if(playerLives == 0)
            gameOver = true;
    }


    //Simulates a collision between a bird and a helicopter
    public void collisionBirdXHelicopter(){
        Bird collide = new Bird();
        if(playerHelicopter.getDamageLevel() <
           playerHelicopter.getMaxDamageLevel()) {
            playerHelicopter.increaseDamageLevel(collide.applyDamage());
        }else if(playerHelicopter.getDamageLevel() >=
                playerHelicopter.getMaxDamageLevel()) {
            reduceLives();
            playerHelicopter.resetDamageLevel();
        }
        playerHelicopter.modifyColor(1);
    }

    //Simulates a collision between helicopters
    public void collisionHelicopters(){
        if(playerHelicopter.getDamageLevel() <
                playerHelicopter.getMaxDamageLevel()) {
            playerHelicopter.increaseDamageLevel
                    (playerHelicopter.applyDamage());
        }else if(playerHelicopter.getDamageLevel() >=
                playerHelicopter.getMaxDamageLevel()) {
            reduceLives();
            playerHelicopter.resetDamageLevel();
        }
        playerHelicopter.modifyColor(1);
    }

    //Simulates a collision between a RefuelingBlimp and a helicopter
    public void collisionRefuelingBlimpXHelicopter(){
        RefuelingBlimps r = new RefuelingBlimps();
        playerHelicopter.increaseFuelLevel(r.getFuelLevel());
        for (GameObject g : list){
            if(g instanceof RefuelingBlimps){
                ((RefuelingBlimps) g).refuel();
            }
        }
    }

    //updates lastSkyScraperReached to value passed
    public void updateSkyScraper(int s){
        if(s == playerHelicopter.getLastSkyScraperReached() + 1){
            playerHelicopter.setLastSkyScraperReached
                    (playerHelicopter.getLastSkyScraperReached() + 1);
        }else{
            throw new IllegalArgumentException("SkyScraper inputted " +
                    "invalid ");
        }
    }

    //Simulates the events that occur during one clock tick
    public void trackTicks(){
        for (Movable m : movableObjects){
            if(m instanceof Helicopter){
                if((((Helicopter) m).getFuelLevel() > 0) &&
                        ((Helicopter) m).getDamageLevel() <
                                ((Helicopter) m).getMaxDamageLevel() ) {
                    ((Helicopter) m).reduceFuelLevel();
                    if(storedRightMoves > 0 && storedLeftMoves > 0){
                        storedLeftMoves--;
                        storedRightMoves--;
                        if(storedLeftMoves > 0 && storedRightMoves == 0) {
                            m.steer(-5);
                        }else if(storedRightMoves > 0 && storedLeftMoves == 0) {
                            m.steer(5);
                        }
                    }
                }
            }
            m.move();
        }
        timePassed++;
    }

    //Displays the player values assigned to the player
    public void displayPlayerValues(){
        System.out.println("Player Lives left: " + playerLives);
        System.out.println("Time Passed: " + timePassed);
    }

    //Displays the current state of the player's helicopter
    public void displayHelicopterState(){
        Helicopter findPlayer = new Helicopter();
        int index = 0;
        for(GameObject gameObjects : list){
            if(gameObjects instanceof Helicopter){
                findPlayer = (Helicopter) list.get(index);
            }else{
                index++;
            }
        }
        System.out.println("Highest SkyScraper reached: " +
                            findPlayer.getLastSkyScraperReached());
        System.out.println("Current Fuel Level: " + findPlayer.getFuelLevel());
        System.out.println("Current Damage Level: " +
                            findPlayer.getDamageLevel());
    }

    //Displays all of the current objects that exist in the world
    public void displayMap() {
        SkyScraper skyScrapers = new SkyScraper();
        RefuelingBlimps blimps = new RefuelingBlimps();
        Bird birds = new Bird();
        Helicopter heli = new Helicopter();

        for (GameObject gameObj : list) {
            if (gameObj instanceof SkyScraper){
                skyScrapers = (SkyScraper) gameObj;
                System.out.println("SkyScraper: " + "Location: " +
                        skyScrapers.getLocationX() + ", " +
                        skyScrapers.getLocationY() + " Color: [" +
                        skyScrapers.getColorR() + ", " +
                        skyScrapers.getColorG() + ", " +
                        skyScrapers.getColorB() + "] Size: " +
                        skyScrapers.getSize() + " Sequence #: " +
                        skyScrapers.getSequenceNumber());
            }else if (gameObj instanceof RefuelingBlimps){
                blimps = (RefuelingBlimps) gameObj;
                System.out.println("RefuelingBlimp: " + "Location: " +
                        blimps.getLocationX() + ", " +
                        blimps.getLocationY() + " Color: [" +
                        blimps.getColorR() + ", " +
                        blimps.getColorG() + ", " +
                        blimps.getColorB() + "] Size: " +
                        blimps.getSize() + " Capacity:  " +
                        blimps.getFuelCapacity());
            }else if (gameObj instanceof Bird){
                birds = (Bird) gameObj;
                System.out.println("Bird: " + "Location: " +
                        birds.getLocationX() + ", " +
                        birds.getLocationY() + " Color: [" +
                        birds.getColorR() + ", " +
                        birds.getColorG() + ", " +
                        birds.getColorB() + "] Heading: " +
                        birds.getHeading() + " Speed: " +
                        birds.getSpeed() + " Size: " +
                        birds.getSize());
            }else if (gameObj instanceof Helicopter){
                heli = (Helicopter) gameObj;
                System.out.println("Helicopter: " + "Location: " +
                        heli.getLocationX() + ", " +
                        heli.getLocationY() + " Color: [" +
                        heli.getColorR() + ", " +
                        heli.getColorG() + ", " +
                        heli.getColorB() + "] Heading: " +
                        heli.getHeading() + " Speed: " +
                        heli.getSpeed() + " Size: " +
                        heli.getSize() + " Max Speed: " +
                        heli.getMaxSpeed() + " Stick Angle: "  +
                        heli.getStickAngle() + " Fuel Level: " +
                        heli.getFuelLevel() + " Damage Level: " +
                        heli.getDamageLevel());
            }
            System.out.println("===============");
        }
    }

    //Prompts the system to exit
    public void exit(){
        System.exit(0);
    }

    //Getter method for exitConfirm
    public boolean getExitConfirm(){
        return exitConfirm;
    }

    //Setter method for exitConfirm
    public void setExitConfirmTrue(){
        exitConfirm = true;
    }

    //Setter method for exitConfirm
    public void setExitConfirmFalse(){
        exitConfirm = false;
    }
}
