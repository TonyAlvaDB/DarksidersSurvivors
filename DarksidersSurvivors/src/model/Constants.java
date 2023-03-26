/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Constants {
    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int WALK = 1;
        public static final int HURT = 2;
        public static final int SWORD = 3;
        public static final int RUN = 4;
        public static final int ROLL = 5;
        
        public static int GetSpriteAmount(int player_action){
            switch (player_action) {
                case IDLE:
                    return 5;
                case WALK:    
                case HURT:    
                case RUN:    
                    return 6;
                case SWORD:    
                    return 10;
                case ROLL:
                    return 11;
                default:
                    return 1;
            }
        }
    }
}
