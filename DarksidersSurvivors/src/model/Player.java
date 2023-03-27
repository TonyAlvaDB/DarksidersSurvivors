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
    private int playerDirection;
    private boolean moving;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
        this.moving = false;
        this.playerAction = IDLE;
        this.playerDirection = -1;
        this.animationIndex = this.animationSpeed = this.animationTick = 25;
    }
    
    public void update(){
        updateAnimationTick();
        setAnimation();
        updatePosition();
    }
    
    public void render(Graphics g){
        g.drawImage(animations[playerAction][animationIndex], (int)x, (int) y,120, 120,  null);
    }
    
    public void setDirection(int direction){
        this.playerDirection = direction;
        this.moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
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
        if(moving){
            switch (playerDirection) {
                case LEFT:
                    x -= 1;
                    break;
                case UP:
                    y -= 1;
                    break;
                case RIGHT:
                    x += 1;
                    break;
                case DOWN:
                    y += 1;
                    break;
                
            }
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
    
}
