package org.yyym.model;

import org.yyym.controller.action.KeyboardAction;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends ElementObj implements Runnable{

    private KeyboardAction keyboardAction;
    private KeyboardAction lastAction;

    private Map<KeyboardAction, List<ImageIcon>> moveCartoon = new HashMap<>();

    public Player(int x, int y,
                  List<ImageIcon> l, List<ImageIcon> r, List<ImageIcon> t, List<ImageIcon> b) {
        super(x, y, b.get(0).getIconWidth(), b.get(0).getIconHeight(), b.get(0));
        moveCartoon.put(KeyboardAction.TOP_W, t);
        moveCartoon.put(KeyboardAction.BOTTOM_S, b);
        moveCartoon.put(KeyboardAction.LEFT_A, l);
        moveCartoon.put(KeyboardAction.RIGHT_D, r);
        new Thread(this).start();
    }

    @Override
    public void show(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

   @Override
   public synchronized void handleKeyboardAction(Boolean clicking, KeyboardAction action) {
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
                    System.out.println(" ");
                    if(keyboardAction == null) {
                        if(pos != 0 && this.lastAction != null) {
                            this.setIcon(moveCartoon.get(lastAction).get(0));
                            pos = 0; Thread.sleep(150);
                        }
                        continue;
                    }
//                    System.out.println("------~~~" + pos);
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
