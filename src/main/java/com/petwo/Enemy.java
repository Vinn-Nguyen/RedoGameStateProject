/*
 Name: Wren Nguyen
 Date: 12.08.2024
 Description: Information for the enemy objects is stored here. Enemy is red and drawn as a squares.
 Q changes enemies from squares to circles
*/

package com.petwo;
import processing.core.*;
 
public class Enemy extends NPC{ //inherits from NPC
    Enemy(PApplet main_){
        super(main_,60, main_.color(255,0,0), 1);
    }
 
    //changes from squares to circles
    void shapeChange(){
        shapeType = 2;
    }
}