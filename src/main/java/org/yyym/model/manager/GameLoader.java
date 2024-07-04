package org.yyym.model.manager;

import lombok.Getter;
import org.yyym.controller.action.KeyboardAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLoader {
    @Getter
    private static final GameLoader loader = new GameLoader();
    private final Map<SingleSource, ImageIcon> singleSource = new HashMap<>();
    private final Map<GroupSource, List<ImageIcon>> groupSource = new HashMap<>();

    GameLoader() {
        for(GroupSource lg : GroupSource.values())
            groupSource.put(lg, new ArrayList<>());
        loadPlayerImg();
    }

    private void loadPlayerImg() {
        List<GroupSource> type = List.of(GroupSource.DEFAULT_PLAYER1_CARTOON_B,
                GroupSource.DEFAULT_PLAYER1_CARTOON_L,
                GroupSource.DEFAULT_PLAYER1_CARTOON_R,
                GroupSource.DEFAULT_PLAYER1_CARTOON_T);
        for(int i = 0 ; i < 4 ; i ++) {
            for(int j = 0 ; j < 4 ; j ++) {
                System.out.println(type.get(i));
                groupSource.get(type.get(i))
                        .add(readSmallImage("src/main/resources/static/player/Done_body16001_walk.png",
                                25 + j * 100, 40 + 100 * i, 50, 60));
            }
        }

    }


    public ImageIcon getExactSource_S(SingleSource type) {
        return singleSource.get(type);
    }
    public List<ImageIcon> getExactSource_G(GroupSource type) {
        return groupSource.get(type);
    }

    private ImageIcon readSmallImage(String path, int x, int y, int w, int h) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage subImage = image.getSubimage(x, y, w, h);
            return new ImageIcon(subImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
