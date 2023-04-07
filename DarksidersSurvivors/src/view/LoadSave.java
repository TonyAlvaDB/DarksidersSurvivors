package view;

import controller.Game;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import static model.Constants.EnemyConstants.ORC;
import model.Orc;

public class LoadSave {

    public static final String PLAYER_ATLAS = "SpriteSheet.png";
    public static final String BASE_BACKGROUND = "background.png";
    public static final String MENU_BUTTONS = "button_atlas.png";
    public static final String MENU_BACKGROUND = "background_menu.jpg";
    public static final String ENEMY_ONE = "skeleton_Big.jpg";
    public static final String ORC_ENEMY = "orc_small.png";

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

    public static ArrayList<Orc> GetOrcs() {
        BufferedImage img = GetSpriteAtlas(ORC_ENEMY);
        ArrayList<Orc> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++) {
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == ORC) {
                    list.add(new Orc(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
                }
            }
        }
        return list;
    }
}
