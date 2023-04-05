/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.Gamestate;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class MouseInputs implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;
    
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    
    public void mouseClicked(MouseEvent e) {
        switch(Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseClicked(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseClicked(e);
                break;
            default:
                break;
        }
        
    }

    
    public void mousePressed(MouseEvent e) {
    }

    
    public void mouseReleased(MouseEvent e) {
    }

    
    public void mouseEntered(MouseEvent e) {
    }

    
    public void mouseExited(MouseEvent e) {
    }

    
    public void mouseDragged(MouseEvent e) {
    }

    
    public void mouseMoved(MouseEvent e) {
    }

}
