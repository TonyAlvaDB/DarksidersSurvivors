/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Game;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Constants {
    public static class UI {
        public static class Buttons {
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
            }
    }
    
    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    
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
