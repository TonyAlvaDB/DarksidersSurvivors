/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics;
import view.GamePanel;
import view.GameWindow;

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
    
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    
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
        
        
        switch(Gamestate.state){
            case MENU:
                //menu.update();
                break;
            case PLAYING:

                break;
            default:
                break;
        }
    }
    
    public void render(Graphics g){
        switch(Gamestate.state){
            case MENU:
                //menu.render(g);
                break;
            case PLAYING:

                break;
            default:
                break;
       }
        
        
    }   
    
    private void initClasses() {
        
    }

    public void windowFocusLost(){
        player.resetDirBooleans();
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
