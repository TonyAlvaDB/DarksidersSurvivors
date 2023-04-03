package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GamePanel;
import static model.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    
    public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
    }

    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(false);
                break;

            }
    }

    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                    gamePanel.getGame().getPlayer().setUp(true);
                    break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                    gamePanel.getGame().getPlayer().setLeft(true);
                    break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                    gamePanel.getGame().getPlayer().setDown(true);
                    break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                    gamePanel.getGame().getPlayer().setRight(true);
                    break;
            case KeyEvent.VK_1:
                gamePanel.getGame().getPlayer().setAttacking(true);
                break;
            }
    }
}
