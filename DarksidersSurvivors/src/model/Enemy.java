/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */

import controller.Game;
import java.awt.Graphics;
import static model.Constants.Directions.*;
import static model.Constants.EnemyConstants.*;
public abstract class Enemy extends Entity {

    private int aniIndex, enemyState, enemyType;
    private int aniTick, aniSpeed = 30;
    private float walkSpeed = 1.0f * Game.SCALE;
    private int walkDir = LEFT;
    protected float attackDistance = Game.TILES_SIZE;

    public Enemy(float x, float y, int width, int height, int enemyType) {
    super(x, y, width, height);
        this.enemyType = enemyType;
        initHitbox(x, y, width, height);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(enemyType, enemyState)) {
                aniIndex = 0;
            }
        }
    }

    public void update() {
        updateAnimationTick();
        updateMove();
    }
    
    public void render(Graphics g){
        drawHitbox(g);
        
    }
    
    private void updateMove(){
           
        
    }

    protected boolean canSeePlayer(Player player){
        int playerY = (int) player.getHitbox().y;
        int playerX = (int) player.getHitbox().x;
        if (isPlayerInRange(player))
            return true;
        return false;
            
        
    }
    private boolean isPlayerInRange(Player player){
        int absValueX = (int) Math.abs(player.hitbox.x - hitbox.x);
        int absValueY = (int) Math.abs(player.hitbox.y - hitbox.y);
        if(absValueX <= attackDistance*5 && absValueY <= attackDistance*5)
            return true;
        return false;
    }

    
    public int getAniIndex() {
        return aniIndex;
    }

    public int getEnemyState() {
        return enemyState;
    }

    private void changeWalkDir() {
        if(walkDir == LEFT)
            walkDir = RIGHT;
        else
            walkDir = LEFT;
        
    }
    



}
