package org.yyym.model.manager;

import lombok.Getter;
import org.yyym.controller.action.KeyboardAction;
import org.yyym.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class GameLoader {
    private static final Properties pro = new Properties();

    private static final String playerProPath = "src/main/java/org/yyym/PlayerProperties.pro";

    public static void loadPlayerSource(Player player, GameElement ele) throws Exception {
        InputStream playerIni = new FileInputStream(new File(playerProPath));
        pro.clear(); pro.load(playerIni);
        Enumeration<?> names = pro.propertyNames();
        String imgPath = "";
        while (names.hasMoreElements()) {
            String key = names.nextElement().toString();
            if(key.equals(ele.toString())) {
                imgPath = pro.getProperty(key); break;
            }
        }
        for(int i = 0 ; i < 4 ; i ++) {
            List<ImageIcon> icons = new ArrayList<>();
            for(int j = 0 ; j < 4 ; j ++)
                icons.add(readSmallImage(imgPath, 25 + j * 100, 40 + 100 * i, 50, 60));
            player.getMoveCartoon().put(ele.actions().get(i), icons);
        }
    }

    private static ImageIcon readSmallImage(String path, int x, int y, int w, int h) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage subImage = image.getSubimage(x, y, w, h);
            return new ImageIcon(subImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
