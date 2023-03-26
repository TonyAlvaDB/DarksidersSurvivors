/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

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
    
    public Game (){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run() {
        double timePerFrame = 1000000000 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        
        while(true){
            now = System.nanoTime();
            if(now-lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }
            
            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}