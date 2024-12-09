/* 
 * Name: Wren Nguyen
 * Date: 12.08.2024
 * Description: Game Pause screen that appears when the player presses 'P' to pause the game.
*/

package com.petwo;
import processing.core.*;

public class GamePauseController extends GameController {
    GamePauseController(PApplet main_){
        super(main_);
    }

    //pause screen
    public void draw(){
        main.background(0);
        main.textSize(20);
        main.fill(255);
        main.text("Game Paused.", (main.width/2)-50, (main.height/2));
        main.text("Press 'P' to resume", (main.width/2)-75, (main.height/2)+25);
    }

    //P is pause and resume game
    public void keyPressed(){
        if(main.key == 'p'){
            nextController = GameController.GAME_PLAY;
        }
    }
}
