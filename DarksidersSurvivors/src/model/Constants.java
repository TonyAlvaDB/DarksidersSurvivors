/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Game;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
public class Constants {

    public static class EnemyConstants {

        public static final int ORC = 0;
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;
        public static final int DEAD = 3;

        public static final int ENEMY_TWO_WIDTH_DEFAULT = 48;
        public static final int ENEMY_TWO_HEIGHT_DEFAULT = 32;

        public static final int ENEMY_TWO_WIDTH = (int) ((int) (ENEMY_TWO_WIDTH_DEFAULT) * Game.SCALE);
        public static final int ENEMY_TWO_HEIGHT = (int) ((int) (ENEMY_TWO_HEIGHT_DEFAULT) * Game.SCALE);

        public static int GetSpriteAmount(int enemy_type, int enemy_state) {
            switch (enemy_type) {
                case ORC:
                    switch (enemy_state) {
                        case IDLE:
                            return 5;

                        case RUNNING:
                            return 8;

                        case ATTACK:
                            return 7;

                        case DEAD:
                            return 3;

                        default:
                            break;
                    }
                    break;
                default:

            }
            return 0;
        }
    }

    public static class Directions {

        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {

        public static final int IDLE = 0;
        public static final int WALK = 1;
        public static final int HURT = 2;
        public static final int SWORD = 3;
        public static final int RUN = 4;
        public static final int ROLL = 5;

        public static int GetSpriteAmount(int player_action) {
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
