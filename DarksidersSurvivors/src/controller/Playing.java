/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import model.EnemyManager;
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
    private boolean paused;
    private EnemyManager enemyManager;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        
        levelManager = new LevelManager(game);
        enemyManager = new EnemyManager(this);
        player = new Player(Game.GAME_HEIGHT/2, Game.GAME_WIDTH/2, 40 * (int) Game.SCALE, 50 * (int) Game.SCALE);
        
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public Player getPlayer() {
        return player;
    }

    
    public void update() {
        levelManager.update();
        player.update();
        enemyManager.update();
    }

    
    public void draw(Graphics g) {
        levelManager.drawBackgroundMap(g);
        player.render(g);
        enemyManager.draw(g);
        
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
            case KeyEvent.VK_BACK_SPACE:
                Gamestate.state = Gamestate.MENU;
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
