/* 
 * Name: Wren Nguyen
 * Date: 12.08.2024
 * Description: Game Start screen that appears at the beginning of the game and after gameover
*/

package com.petwo;
import processing.core.*;

public class GameStartController extends GameController {
    GameStartController(PApplet main_){
        super(main_);
    }

    //start screen
    public void draw(){
        main.background(0);
        main.textSize(20);
        main.fill(255);
        main.text("Game Start", (main.width/2)-50, (main.height/2));
        main.text("Press ENTER to start", (main.width/2)-100, (main.height/2)+25);
    }

    //ENTER is start the game
    public void keyPressed(){
        if(main.key == PApplet.ENTER){
            nextController = GameController.GAME_PLAY; //switch to game play
        }
    }
}
