/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import view.LoadSave;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
public class Menu extends State implements Statemethods {

    private BufferedImage backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;

    public Menu(Game game) {
        super(game);
        loadBackground();

    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
        menuWidth = (int) (backgroundImg.getWidth() * Game.SCALE);
        menuHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
        menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
        menuY = (int) (1 * Game.SCALE);


    }

    public void draw(Graphics g) {

        g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);

        g.setFont(g.getFont().deriveFont(4, 30f));

        g.setColor(Color.black);
        g.drawString("Presione la tecla Enter para comenzar", 220, Game.GAME_WIDTH / 2);

    }

    public void mouseClicked(MouseEvent e) {
        

    }

    public void mousePressed(MouseEvent e) {
       

    }

    public void mouseReleased(MouseEvent e) {
      

    }

    private void resetButtons() {
       
    }

    public void mouseMoved(MouseEvent e) {
        

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Gamestate.state = Gamestate.PLAYING;
        }

    }

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }


    public void update() {
    }

}
