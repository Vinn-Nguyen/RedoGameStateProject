/*
 Name: Wren Nguyen
 Date: 12.08.2024
 Description: Particle Engine 2
 Gamestates:
 - GameStart = Start Screen
 - GamePause = Pause Screen
 - GameEnd = Game Over Screen

 GameInfo:
 - Avatar is the blue rectangle, Food is green circles, Trash is white circles, Enemies are red squares.
 - Food increase health by 1. Trash resets health back to 0. Enemies reduce health by 1.
 - Enemies bounce off of each other
 
 KeyPress:
 - 'Q' key is pressed
        Food will change color
        Trash will increase in size
        Enemy will become become circles

 - 'P' key pauses game
 - ENTER key starts game
 - SPACEBAR resets the game
*/

package com.petwo;
import java.util.ArrayList;
import processing.core.*;

public class Main extends PApplet{
    //init
    ArrayList<GameController> controllers = new ArrayList<>();
    int curController = GameController.GAME_START;  // Set to LEVEL_START initially
    
    public static void main(String[] args) {
        PApplet.main("com.petwo.Main"); //runs processing
    }

    public void settings(){
        size(700, 700); //canvas size
        controllers.add(new GameplayController(this));
        controllers.add(new GameEndController(this));
        controllers.add(new GamePauseController(this));  // Add the pause controller
        controllers.add(new GameStartController(this)); // Add the level start controller
    }
    
    public void setup(){
    }

    public void draw(){
        controllers.get(curController).draw(); //draws from the controller
        if(controllers.get(curController).switchController() > GameController.DO_NOT_CHANGE){
            int nextControl = controllers.get(curController).switchController();
            controllers.get(curController).reset();
            curController = nextControl;
        }
    }

    public void mouseDragged(){
        controllers.get(curController).mouseDragged(); //allows avatar to be dragged
    }

    public void keyPressed(){
        controllers.get(curController).keyPressed();
    }
}
