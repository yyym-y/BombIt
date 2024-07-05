package org.yyym.model;

import lombok.Getter;
import org.yyym.controller.action.KeyboardAction;
import org.yyym.model.manager.GameElement;
import org.yyym.model.manager.GameLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends ElementObj implements Runnable{

    private KeyboardAction keyboardAction;
    private KeyboardAction lastAction;
    private final GameElement playerEle;

    @Getter
    private final Map<KeyboardAction, List<ImageIcon>> moveCartoon = new HashMap<>();

    public Player(int x, int y, GameElement playerEle) throws Exception {
        this.setX(x); this.setY(y); this.playerEle = playerEle;
        GameLoader.loadPlayerSource(this, playerEle);
        this.setIcon(moveCartoon.get(playerEle.actions().get(0)).get(0));
        this.setHeight(this.getIcon().getIconHeight());
        this.setWidth(this.getIcon().getIconWidth());
        new Thread(this).start();
    }

    @Override
    public void show(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

   @Override
   public synchronized void handleKeyboardAction(Boolean clicking, KeyboardAction action) {
        if(! playerEle.actions().contains(action)) return;
        if(!clicking && this.keyboardAction.equals(action)) {
            this.lastAction = this.keyboardAction;
            this.keyboardAction = null; return;
        }
        if(clicking)
            this.keyboardAction = action;
   }

   @Override
   public synchronized void elementMove() {
        if(this.keyboardAction != null)
            this.keyboardAction.effectMove(this);
   }

   @Override
   public synchronized void modelHandler() {
        this.elementMove();
   }

    @Override
    public void run() {
        int pos = 0;
        while (true) {
            try {
                synchronized (new Object()) {
                    //System.out.println(keyboardAction + " " + lastAction + " " + pos);
                    if(keyboardAction == null) {
                        if(lastAction != null && ! this.getIcon().equals(moveCartoon.get(lastAction).get(0))) {
                            this.setIcon(moveCartoon.get(lastAction).get(0));
                            pos = 0;
                        }
                        Thread.sleep(100);
                        continue;
                    }
                    this.setIcon(moveCartoon.get(this.keyboardAction).get(pos));
                    pos ++; pos %= moveCartoon.get(this.keyboardAction).size();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
