/*
 Name: Wren Nguyen
 Date: 12.08.2024
 Description: Information for the trash object is stored here. Trash is white and drawn as circles.
 When Q is pressed, size changes
*/

package com.petwo;
import processing.core.*;
 
public class Trash extends NPC{ //inherits from NPC
    Trash(PApplet main_){
        super(main_, 50, main_.color(255,255,255), 2);
    }
 
    void szChange(){ //makes the size bigger
        sz = 100;
    }
}