package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.Game;

public class LevelManager {

    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(Game game) {
        this.game = game;
        
    }


    public void drawBackgroundMap(Graphics g){
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BASE_BACKGROUND);
        g.drawImage(img, 0, 0,Game.GAME_HEIGHT, Game.GAME_WIDTH, null);
    }
    


    public void update() {

    }

}
