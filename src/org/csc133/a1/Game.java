package org.csc133.a1;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import com.codename1.ui.Form;

/* Author: Inigo Jaque
 *  Class: CSC 133 Section 05
 *  Project: SkyMail3000 Part 1
 *  Last Updated: 3/5/2020
 * */

public class Game extends Form{

    private GameWorld gw;
    public Game(){
        gw = new GameWorld();
        gw.init();
        play();
    }
    private void play() {
        Label myLabel=new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField=new TextField();
        this.addComponent(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                String sCommand=myTextField.getText().toString();
                if (sCommand == null || sCommand.equals(""))
                    return;
                myTextField.clear();
                switch (sCommand.charAt(0)){
                    case 'a':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // accelerate - increase speed of player
                            gw.accelerate();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'b':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // brake - reduce speed of player
                            gw.brake();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'l':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // left - change the stick angle 5 degrees to the left
                            gw.playerHelicopterLeft();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'r':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // right - change the stick angle 5 degrees to the right
                            gw.playerHelicopterRight();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'c':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // collided - pretend that a helicopter collided with
                            // another helicopter
                            gw.collisionHelicopters();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '1':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 1
                            gw.updateSkyScraper(1);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '2':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 2
                            gw.updateSkyScraper(2);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '3':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 3
                            gw.updateSkyScraper(3);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '4':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 4
                            gw.updateSkyScraper(4);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '5':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 5
                            gw.updateSkyScraper(5);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '6':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 6
                            gw.updateSkyScraper(6);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '7':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 7
                            gw.updateSkyScraper(7);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '8':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 8
                            gw.updateSkyScraper(8);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case '9':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            //input to update lastSkyScraperReached to 9
                            gw.updateSkyScraper(9);
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'e':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // collided - pretend that a helicopter collided with a
                            // Refueling Blimp
                            gw.collisionRefuelingBlimpXHelicopter();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'g':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // gummed up - pretend a helicopter has collided with a
                            // bird
                            gw.collisionBirdXHelicopter();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 't':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // ticked - tell the game that the game
                            // clock has ticked
                            gw.trackTicks();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'd':
                        //Checks if request to exit has been initiated
                        if(!gw.getExitConfirm()) {
                            // display - display the current state
                            // of game and the state of the player
                            gw.displayPlayerValues();
                            // helicopter state values
                            gw.displayHelicopterState();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'm':
                        //Checks if request to exit has been initiated
                        //displays the current objects that have been created
                        if(!gw.getExitConfirm()) {
                            gw.displayMap();
                        }else {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to " +
                                    "exit the game? Y/N ");
                        }
                        break;
                    case 'x':
                        gw.setExitConfirmTrue();
                        System.out.println("Would you like to exit the game? "
                                        + " Y/N ");
                        break;
                    case 'y':
                        // yes confirm exit
                        if (gw.getExitConfirm()) {
                            gw.exit();
                        }
                        break;
                    case 'n':
                        //no did not confirm exit
                        gw.setExitConfirmFalse();
                        break;
                    default:
                        System.err.println("Please input a valid key");
                        break;
                        // add code to handle rest of the commands
                }
            }
        });
    }
}

