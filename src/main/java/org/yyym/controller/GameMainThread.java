package org.yyym.controller;

import org.yyym.model.ElementObj;
import org.yyym.model.Player;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;

public class GameMainThread extends Thread {
    private final ElementManager em = ElementManager.getEM();

    @Override
    public void run() {
        while (true) {
            try {
                loadGameSource();
                gameRunning();
                sleep(50);
            } catch (InterruptedException ignored) {
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    void loadGameSource() throws Exception {
        em.addExtraEMData(GameElement.PLAYER1, new Player(5, 5, GameElement.PLAYER1));
        em.addExtraEMData(GameElement.PLAYER1, new Player(800, 500, GameElement.PLAYER2));
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
