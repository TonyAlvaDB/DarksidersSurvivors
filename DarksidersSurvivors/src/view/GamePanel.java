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
    public GamePanel(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(100, 100, 200, 50);
        
    }
}
