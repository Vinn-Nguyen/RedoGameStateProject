/*
 Name: Wren Nguyen
 Date: 12.08.2024
 Description: Superclass for all the shapes within the Particle Engine
*/

package com.petwo;
import processing.core.*;
 
public class Shapes {
    static PApplet main; //processing functionality
 
    //UNITS
    float x, y; //x and y position
    float speedX = 1; //speed of x
    float speedY = 1; //speed of y
    float sz; //size of object
    float half; //half of the object's size
    int color; //color
    boolean hit; //collision boolean for when objects interact
    int shapeType; //draws the shape type: 1 = squares | 2 = circle | 3 = rectangle
 
 
    //Superclass parent
    Shapes(PApplet main_, float sz_, int color_, int shapeType_){
        main = main_;
        sz = sz_;
        color = color_;
        shapeType = shapeType_;
    }
 
    //displays all objects
    void display(){
        main.fill(color); //colors object
        main.noStroke();
        
        //shapetype determines what shape is drawn
        if(shapeType == 1){ //draw square for enemies
            main.rectMode(PApplet.CENTER);
            main.rect(x, y, sz, sz);
        }
        else if (shapeType == 2 ){ //draws circles for food 
            main.ellipse(x, y, sz, sz);
        }
        else{ //draws rectangle for avatar
            main.rect(x, y, sz+20, sz);
        }
    }
    
    //collision between objects
    boolean isHit(Shapes shapes){ 
        float distance = PApplet.dist(x, y, shapes.getX(), shapes.getY());
        return (distance < sz/2 + shapes.getSz()/2);
    }
 
     //functions to get the X, Y, and object Size
    float getX(){
        return x;
    }

    float getY(){
        return y;
    }

    float getSz(){
        return sz;
    }
}