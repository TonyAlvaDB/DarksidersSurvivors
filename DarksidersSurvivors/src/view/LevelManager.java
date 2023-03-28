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
    private BufferedImage[] levelSprite;
    
    
    public LevelManager(Game game){
        this.game = game;
        //levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        importOutsideSprites();
    }
    
    public void draw(Graphics g){
        
        g.drawImage(levelSprite[32], 0, 0, null);
    }
    
    private void importOutsideSprites() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[64];
        for(int j = 0; j < 5; j++)
            for(int i = 0; i < 5; i++){
                int index = j*8 + i;
                levelSprite[index] = img.getSubimage(i*16, j*16, 16, 16);
            }
    }
    public void update(){
        
    }

    
}
