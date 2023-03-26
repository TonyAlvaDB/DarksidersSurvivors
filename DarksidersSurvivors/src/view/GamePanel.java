/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class GamePanel extends JPanel{
    private int xDelta;
    private int yDelta;
    
    public GamePanel(){
        addKeyListener(new KeyboardInputs(this));
        this.xDelta = 0;
        this.yDelta = 0;
    }
    public void changeXDelta(int value){
        this.xDelta += value;
        
    }
    public void changeYDelta(int value){
        this.yDelta += value;
        
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(100+xDelta, 100+yDelta, 200, 50);
        repaint();
    }
}
