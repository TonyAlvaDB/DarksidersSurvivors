/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Levels {
    private int[][] lvlData;
    public Levels(int[][] lvlData){
        this.lvlData = lvlData;
    }
    
    public int getSpriteIndex(int x, int y){
        return lvlData[y][x];
    }
    
}
