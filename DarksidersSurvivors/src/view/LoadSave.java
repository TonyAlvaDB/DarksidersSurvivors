package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class LoadSave {

    public static final String PLAYER_ATLAS = "SpriteSheet.png";
    public static final String BASE_BACKGROUND = "background.png";
    public static final String MENU_BUTTONS = "button_atlas.png";
    public static final String MENU_BACKGROUND = "background_menu.jpg";
    public static final String ENEMY_ONE = "skeleton_Big.jpg";
    public static final String ENEMY_TWO = "orc_small.jpg";

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
}
