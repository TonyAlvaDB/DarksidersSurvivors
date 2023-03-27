/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static model.Constants.Directions.DOWN;
import static model.Constants.Directions.LEFT;
import static model.Constants.Directions.RIGHT;
import static model.Constants.Directions.UP;
import static model.Constants.PlayerConstants.GetSpriteAmount;
import static model.Constants.PlayerConstants.IDLE;
import static model.Constants.PlayerConstants.WALK;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Player extends Character {
    private BufferedImage[][] animations;
    private int animationTick;
    private int animationIndex;
    private int animationSpeed;
    private int playerAction;
    private boolean left, up, right, down;
    private boolean moving;
    private float playerSpeed;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
        this.moving = false;
        this.playerAction = IDLE;
        this.playerSpeed = 2.0f;
        this.animationIndex = this.animationSpeed = this.animationTick = 30;
    }
    
    public void update(){
       
        updateAnimationTick();
        updatePosition();
        setAnimation();
        
    }
    
    public void render(Graphics g){
        g.drawImage(animations[playerAction][animationIndex], (int)x, (int) y,120, 120,  null);
    }
    
    private void updateAnimationTick() {
        this.animationTick++;
        if(this.animationTick >= this.animationSpeed){
            this.animationTick = 0;
            this.animationIndex++;
            if (this.animationIndex >= GetSpriteAmount(playerAction))
                this.animationIndex = 0;
        }
    }
    
    private void setAnimation() {
        if(moving)
            playerAction = WALK;
        else
            playerAction = IDLE;
    }
    
    private void updatePosition() {
        moving = false;
        
        if(left && !right){
            x-=playerSpeed;
            moving = true;
        } else if (right && !left){
            x+=playerSpeed;
            moving = true;
        }
        
        if(up && !down){
            y-= playerSpeed;
            moving = true;
        } else if(down && !up){
            y=+playerSpeed;
            moving = true;
        }
    
    }

    
    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/SpriteSheet.png");
        try {
            BufferedImage sprite = ImageIO.read(is);
            
            animations = new BufferedImage[6][11];
                for(int j = 0; j < animations.length; j++) 
                    for (int i = 0; i < 11; i++)
                       animations[j][i] = sprite.getSubimage(i*22, j*24, 22, 24);

        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
        
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
    
}
