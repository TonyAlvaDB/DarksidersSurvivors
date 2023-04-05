/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Menu extends State implements Statemethods{

    public Menu(Game game) {
        super(game);
    }

    
    public void update() {
    }

    
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawString("MENU", game.GAME_WIDTH / 2, 200);
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
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            Gamestate.state = Gamestate.PLAYING;
        
    }

    
    public void keyReleased(KeyEvent e) {
    }
    
}
