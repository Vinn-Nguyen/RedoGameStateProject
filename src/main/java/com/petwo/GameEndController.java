/* 
 * Name: Wren Nguyen
 * Date: 12.08.2024
 * Description: Game Over screen that appears when the player looses all of their health. Resets
 * the game when pressing
*/

package com.petwo;
import processing.core.*;

public class GameEndController extends GameController{
    GameEndController(PApplet main_){
        super(main_);
    }

    //Game over end screen
    public void draw(){ 
        main.background(0);
        main.textSize(20);
        main.fill(255);
        main.text("Game Over!!", (main.width/2)-50, (main.height/2));
        main.text("Press SPACEBAR to replay the game", (main.width/2)-150, (main.height/2)+25);
    }

    //Press Space bar to replay game
    public void keyPressed(){
        if(main.key == ' '){
            nextController = GameController.GAME_START; 
        }
    }
}