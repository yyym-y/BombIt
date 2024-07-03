package org.yyym;

import org.yyym.model.manager.GameElement;
import org.yyym.view.GameJFrame;
import org.yyym.view.GameMainJPanel;

import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameJFrame gj = new GameJFrame();
        GameMainJPanel jp = new GameMainJPanel();

        gj.setJPanel(jp);
        gj.setKeyListener(null);
        gj.start();
    }
}