/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static model.Constants.PlayerConstants.*;
import static model.Constants.Directions.*;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class GamePanel extends JPanel{
    private int xDelta;
    private int yDelta;
    private int frames;
    private BufferedImage sprite;
    private BufferedImage[][] animations;
    private int animationTick;
    private int animationIndex;
    private int animationSpeed;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving;
    
    public GamePanel(){
        
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        this.xDelta = 0;
        this.yDelta = 0;
        this.frames = 0;
        this.animationIndex = this.animationSpeed = this.animationTick = 20;   
        this.moving = false;
        importImage();
        loadAnimations();
    }
    
    public void setDirection(int direction){
        this.playerAction = direction;
        this.moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }
    
    private void setPanelSize() {
        Dimension size = new Dimension(800, 600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/SpriteSheet.png");
        try {
            sprite = ImageIO.read(is);
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

    private void loadAnimations() {
        animations = new BufferedImage[6][11];
        for(int j = 0; j < animations.length; j++) 
            for (int i = 0; i < 11; i++)
               animations[j][i] = sprite.getSubimage(i*22, j*24, 22, 24);
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
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -= 5;
                    break;
                case RIGHT:
                    xDelta +=5;
                    break;
                case DOWN:
                    yDelta += 5;
                    break;
                
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePosition();
        g.drawImage(animations[playerAction][animationIndex], (int)xDelta, (int) yDelta,120, 120,  this);
    }

    

    

}
