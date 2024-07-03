package org.yyym.controller;

import org.yyym.model.ElementObj;
import org.yyym.model.Player;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;

import javax.swing.*;

public class GameMainThread extends Thread {
    public ElementManager em = ElementManager.getEM();

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
        ImageIcon icon=new ImageIcon("src/main/resources/static/img.png");
        em.addExtraEMData(GameElement.PLAYER, new Player(5,5,50,50, icon));
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
