package org.yyym.view;

import org.yyym.model.ElementObj;
import org.yyym.model.Player;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameMainJPanel extends JPanel implements Runnable{
    private ElementManager em;

    public GameMainJPanel() {
        this.mainJPanelInit();
    }

    public void mainJPanelInit() {
        this.em = ElementManager.getEM();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(GameElement ele : GameElement.values()) {
            List<ElementObj> objList = em.getExtraEMData(ele);
            for (ElementObj elementObj : objList) {
                elementObj.show(g);
            }
        }
    }

    @Override
    public void run() {
        while ( true ) {
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {}
        }
    }
}
