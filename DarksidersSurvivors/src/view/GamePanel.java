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
    private BufferedImage img;
    
    public GamePanel(){
        
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        this.xDelta = 0;
        this.yDelta = 0;
        this.frames = 0;
        importImage();
    }
    public void changeXDelta(int value){
        this.xDelta += value;
        
    }
    public void changeYDelta(int value){
        this.yDelta += value;
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, WIDTH, WIDTH, null);
        
    
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
            img = ImageIO.read(is);
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
