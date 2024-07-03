package org.yyym.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

public class Player extends ElementObj {

    public Player(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height, icon);
    }

    @Override
    public void show(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
