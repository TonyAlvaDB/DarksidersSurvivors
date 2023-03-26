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
    private BufferedImage[] idleAnimation;
    private int animationTick;
    private int animationIndex;
    private int animationSpeed;
    
    public GamePanel(){
        
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        this.xDelta = 0;
        this.yDelta = 0;
        this.frames = 0;
        this.animationIndex = 10;
        this.animationSpeed = 10;
        this.animationTick = 10;
        importImage();
        loadAnimations();
    }
    
    public void changeXDelta(int value){
        this.xDelta += value;
        
    }
    public void changeYDelta(int value){
        this.yDelta += value;
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        g.drawImage(idleAnimation[0], (int)xDelta, (int) yDelta,90, 120,  this);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(800, 600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/Combat_Ready_Idle.png");
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
       idleAnimation = new BufferedImage[5];
       for (int i = 0; i < idleAnimation.length; i++)
           idleAnimation[i] = sprite.getSubimage(22, 0, 16, 24);
    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= idleAnimation.length)
                animationTick = 0;
        }
    }
}
