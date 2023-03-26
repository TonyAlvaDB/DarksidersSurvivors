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
public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    
    public Game (){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        
    }


}
