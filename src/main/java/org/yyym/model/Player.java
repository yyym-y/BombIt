package org.yyym.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.yyym.controller.action.KeyboardAction;

import javax.swing.*;
import java.awt.*;

public class Player extends ElementObj {

    private KeyboardAction keyboardAction;

    public Player(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height, icon);
    }

    @Override
    public void show(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

   @Override
   public synchronized void handleKeyboardAction(Boolean clicking, KeyboardAction action) {
        if(!clicking && this.keyboardAction.equals(action)) {
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

}
