/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
import controller.Game;
import java.awt.Graphics;
import java.awt.Rectangle;
import static model.Constants.EnemyConstants.*;

public class Orc extends Enemy {

    public Orc(float x, float y) {
            super(x, y, ENEMY_TWO_WIDTH, ENEMY_TWO_HEIGHT, ORC);
            initHitbox(x, y, (int)(30 * Game.SCALE), (int)(30 * Game.SCALE));
            
            
    }

}
