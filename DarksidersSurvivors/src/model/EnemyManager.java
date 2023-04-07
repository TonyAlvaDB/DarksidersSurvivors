/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Playing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import view.LoadSave;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
import static model.Constants.EnemyConstants.*;

public class EnemyManager {

    private Playing playing;
    private BufferedImage[][] orcArray;
    private ArrayList<Orc> orcs = new ArrayList<>();

    public EnemyManager(Playing playing) {
        this.playing = playing;
        loadEnemyImgs();
    }

    public void update() {
        for(Orc o : orcs)
            o.update();
    }
    private void drawOrcs(Graphics g) {
        for(Orc o : orcs)
            g.drawImage(orcArray[o.getEnemyState()][o.getAniIndex()], (int)o.getHitbox().x, (int)o.getHitbox().y, ENEMY_TWO_WIDTH, ENEMY_TWO_HEIGHT, Color.yellow, null);
    }
    public void draw(Graphics g) {
        drawOrcs(g);
    }

    private void loadEnemyImgs() {
        orcArray = new BufferedImage[4][8];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_TWO);
        for (int j = 0; j < orcArray.length; j++) {
            for (int i = 0; i < orcArray[j].length; i++) {
                orcArray[j][i] = temp.getSubimage(i * ENEMY_TWO_WIDTH_DEFAULT, j * ENEMY_TWO_HEIGHT_DEFAULT, ENEMY_TWO_WIDTH_DEFAULT, ENEMY_TWO_HEIGHT_DEFAULT);

            }
        }
    }

    
}
