package org.yyym.view;

import org.yyym.model.ElementObj;
import org.yyym.model.Player;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameMainJPanel extends JPanel {
    private ElementManager em;

    public GameMainJPanel() {
        this.mainJPanelInit();
        this.load();
    }
    public void load() {
        ImageIcon icon=new ImageIcon("src/main/resources/static/img.png");
        ElementObj obj = new Player(100,100,50,50,icon);//实例化对象
        em.addExtraEMData(GameElement.PLAYER, obj);
    }
    public void mainJPanelInit() {
        this.em = ElementManager.getEM();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(GameElement ele : em.getEMData().keySet()) {
            List<ElementObj> objList = em.getExtraEMData(ele);
            for (ElementObj elementObj : objList) {
                elementObj.show(g);
            }
        }
    }
}
