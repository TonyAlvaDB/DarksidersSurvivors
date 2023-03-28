/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics;
import model.Player;
import view.GamePanel;
import view.GameWindow;
import view.LevelManager;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private LevelManager levelManager;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Player player;
    public final static int TILES_DEFAULT_SIZE = 16;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 40;
    public final static int TILES_IN_HEIGHT = 40;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
    
    
    
    public Game (){
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
        
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){
        levelManager.update();
        player.update();
        
    }
    
    public void render(Graphics g){
        //levelManager.draw(g);
        levelManager.drawBackgroundMap(g);
        player.render(g);
        
    }    
    
    private void initClasses() {
        player = new Player(200, 200, 40*(int)SCALE, 50*(int)SCALE);
        levelManager = new LevelManager(this);
    }

    public void windowFocusLost(){
        player.resetDirBooleans();
    }
    
    public Player getPlayer(){
        return player;
    }
    public void run() {
        double timePerFrame = 1000000000 / FPS_SET;
        double timePerUpdate = 1000000000 / UPS_SET;
        long previousTime = System.nanoTime();
        
        
        int frames = 0;
        int updates = 0;
        
        long lastCheck = System.currentTimeMillis();
        
        double deltaUpdates = 0;
        double deltaFrames = 0;
        
        while(true){
            
            long currentTime = System.nanoTime();
            
            deltaUpdates += (currentTime - previousTime)/timePerUpdate;
            deltaFrames += (currentTime - previousTime)/timePerFrame;
            previousTime = currentTime;
            
            if(deltaUpdates >= 1){
                update();
                updates++;
                deltaUpdates--;
            }
            if(deltaFrames >= 1){
                gamePanel.repaint();
                frames++;
                deltaFrames--;
            }
            
            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: "+ updates);
                frames = 0;
                updates = 0;
            }
        }
    }

}
