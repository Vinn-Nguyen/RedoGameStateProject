/* 
 * Name: Wren Nguyen
 * Date: Controls the game states
*/

package com.petwo;
import processing.core.*;

public abstract class GameController {

    PApplet main;
    int nextController = -1;
    static final int DO_NOT_CHANGE = -1;

    //GAME STATES
    static final int GAME_PLAY = 0; //game
    static final int GAME_END = 1; //game over screen
    static final int GAME_PAUSE = 2; //pause screen
    static final int GAME_START = 3; //start screen

    GameController(PApplet main_){
        main = main_;
    }

    public abstract void draw(); //draw

    public void mouseDragged(){
        //do nothing
    }
    public void keyPressed(){
        //do nothing
    }

    //switch game states
    public int switchController(){
        return nextController;
    }

    //reset controller to -1
    public void reset(){
        nextController = DO_NOT_CHANGE;
    }
}
