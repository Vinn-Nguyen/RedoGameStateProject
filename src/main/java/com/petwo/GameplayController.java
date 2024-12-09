/*
* Name: Wren Nguyen
* Date: 12.08.2024
* Description: This object controlls all the shapes and everything relating to it.
*/

package com.petwo;
import java.util.ArrayList;
import processing.core.*;

public class GameplayController extends GameController {
    // Declare other classes
    Shapes shapes;
    NPC npc;
    Avatar avatar;
    Enemy enemies;
    Food foods;

    //array lists
    ArrayList<Shapes> gameObjects;
    ArrayList<NPC> npcs;

    ArrayList<Food> food; //array list for multiple food objects
    int foodCount = 15; //number of food
    
    ArrayList<Enemy> enemy; //array list for multiple enemy objects
    int enemyCount = 4; //number of enemies

    ArrayList<Trash> trash; //array list for multiple trash objects
    int trashCount = 3; //number of trash

    GameplayController(PApplet main_){
        super(main_);
        init(); //initialize the game objects
    }

    //initialize the game objects
    public void init(){  
        avatar = new Avatar(main);
        food = new ArrayList<>();
        enemy = new ArrayList<>();
        trash = new ArrayList<>();
        
        // Create objects in arrays
        for(int i = 0; i < foodCount; i++){
            food.add(new Food(main));
        }
        for(int i = 0; i < enemyCount; i++){
            enemies = new Enemy(main);
            enemy.add(new Enemy(main));
        }
        for(int i = 0; i < trashCount; i++){
            trash.add(new Trash(main));
        }

        //initialize NPCs
        npcs = new ArrayList<>();
        npcs.addAll(food);
        npcs.addAll(enemy);
        npcs.addAll(trash);

        //initialize game objects
        gameObjects = new ArrayList<>();
        gameObjects.add(avatar);
        gameObjects.addAll(npcs);
    }

    //animate game objects
    public void draw(){
        //background
        main.background(0);

        //functions
        display(); 
        collisions();
        move();

        //check if game should stop-- if health <= 0
        if (avatar.getHealth() <= 0){
            nextController = GameController.GAME_END; //switch to game end
        }
    }

    //display all game objects
    public void display(){ 
        //avatar display
        avatar.display(); 

        //display gameobjects
        for(int i = 0; i < gameObjects.size(); i++){
            gameObjects.get(i).display();
        }
    }

    //movement for NPCs
    void move(){ 
        //enemies will bounce off each other
        for(int i = 0; i < enemyCount; i++){
            enemy.get(i).move();
            //check each enemy against the others for collisions
            for(int j = 0; j < enemyCount; j++){
                if(i != j){ //make sure not to check the same enemy against itself
                    enemy.get(i).enemyCollision(enemy.get(j));
                }
            }
        }
        for(int i = 0; i < foodCount; i++){
            food.get(i).move();
        }
        for(int i = 0; i < trashCount; i++){
            trash.get(i).move();
        }
    }

    //collision between avatar and NPCs
    public void collisions(){
        for(int i = 0; i < npcs.size(); i++){
            avatar.collision(npcs.get(i));
            npcs.get(i).collision(avatar);
        }
    }

    //set avatar location
    public void setAvatar(float x, float y){
        avatar.setStart(x, y);
    }

    //avatar is mousedragged
    public void mouseDragged(){
        setAvatar(main.mouseX, main.mouseY);
    }

    //reset gamestate
    public void reset(){
        super.reset();
        init(); //init gamestate
    }

    //keys
    public void keyPressed(){
        //Q = changes to the NPCs
        if(main.key == 'q'){
            //change food color
            for (Food foodChange : food) {
                foodChange.colorChange();
            }

            //increase size of trash
            for (Trash trashChange : trash) {
                trashChange.szChange();
            }

            //change enemy shape to circle
            for (Enemy enemyChange : enemy) {
                enemyChange.shapeChange();
            }
        }

        if(main.key == 'p'){
            nextController = GameController.GAME_PAUSE;
        }

    }
}