/*
 Name: Wren Nguyen
 Date: 12.08.2024
 Description: Information for the food object is stored here. Food is green and drawn as circles.
 Q changes the food from green to yellow.
*/

package com.petwo;
import processing.core.*;
 
public class Food extends NPC{ //inherits from NPC
    static int green = main.color(0, 255,0);
    static int yellow = main.color(255, 255, 0);
 
    Food(PApplet main_){
        super(main_, 20, green, 2);
    }

    //changes color from green to yellow
    void colorChange(){
        color = yellow;
    }

}