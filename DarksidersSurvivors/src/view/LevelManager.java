/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class LevelManager {
    private Game game;
    private BufferedImage levelSprite;
    
    public LevelManager(Game game){
        this.game = game;
        levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
    }
    public void draw(Graphics g){
        g.drawImage(levelSprite, 0, 0, null);
    }
    public void update(){
        
    }
}
