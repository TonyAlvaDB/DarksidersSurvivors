/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs (GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    
    public void keyTyped(KeyEvent e) {
        
    }


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(5);
                break;
        }
    }


    public void keyReleased(KeyEvent e) {
        
    }

}
