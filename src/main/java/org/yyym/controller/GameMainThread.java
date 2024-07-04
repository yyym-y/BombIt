package org.yyym.controller;

import org.yyym.model.ElementObj;
import org.yyym.model.Player;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;
import org.yyym.model.manager.GameLoader;
import org.yyym.model.manager.GroupSource;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class GameMainThread extends Thread {
    private final ElementManager em = ElementManager.getEM();
    private final GameLoader loader = GameLoader.getLoader();

    @Override
    public void run() {
        while (true) {
            loadGameSource();
            gameRunning();
            try {
                sleep(50);
            } catch (InterruptedException ignored) {}
        }
    }

    void loadGameSource() {
        Player player = new Player(5, 5,
                loader.getExactSource_G(GroupSource.DEFAULT_PLAYER1_CARTOON_L),
                loader.getExactSource_G(GroupSource.DEFAULT_PLAYER1_CARTOON_R),
                loader.getExactSource_G(GroupSource.DEFAULT_PLAYER1_CARTOON_T),
                loader.getExactSource_G(GroupSource.DEFAULT_PLAYER1_CARTOON_B));
        em.addExtraEMData(GameElement.PLAYER, player);
    }

    void gameRunning() {
        while (true) {
            for(GameElement ge : GameElement.values()) {
                for(ElementObj ele : em.getExtraEMData(ge))
                    ele.modelHandler();
            }
            try {
                sleep(20);
            } catch (InterruptedException ignored) {}
        }
    }
}
