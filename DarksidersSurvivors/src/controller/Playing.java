/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.Game.SCALE;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import model.Player;
import view.LevelManager;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
public class Playing extends State implements Statemethods {

    private LevelManager levelManager;
    private Player player;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        player = new Player(200, 200, 40 * (int) Game.SCALE, 50 * (int) Game.SCALE);
        levelManager = new LevelManager(game);
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public Player getPlayer() {
        return player;
    }

    
    public void update() {
    }

    
    public void draw(Graphics g) {
    }

    
    public void mouseClicked(MouseEvent e) {
    }

    
    public void mousePressed(MouseEvent e) {
    }

    
    public void mouseReleased(MouseEvent e) {
    }

    
    public void mouseMoved(MouseEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                    player.setUp(true);
                    break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                    player.setLeft(true);
                    break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                    player.setDown(true);
                    break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                    player.setRight(true);
                    break;
            case KeyEvent.VK_1:
                player.setAttacking(true);
                break;
            }
    }

    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                player.setUp(false);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                player.setLeft(false);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                player.setDown(false);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                player.setRight(false);
                break;

            }
    }
}
