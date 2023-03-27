/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static model.Constants.Directions.*;
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

     public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setMoving(false);
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setDirection(RIGHT);
                break;
        }
    }


   

}
