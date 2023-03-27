/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.Game;
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
    private Game game;
    public GamePanel(Game game){
        this.game = game;
        setPanelSize();    
        addKeyListener(new KeyboardInputs(this));
    }
   
    private void setPanelSize() {
        Dimension size = new Dimension(800, 600);
        setPreferredSize(size);
    }
    
    public void updateGame(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame(){
    return game;
    }

    

}
