package org.yyym.controller;

import org.yyym.controller.action.KeyboardAction;
import org.yyym.model.ElementObj;
import org.yyym.model.manager.ElementManager;
import org.yyym.model.manager.GameElement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class GameKeyListener implements KeyListener {
    private final Set<KeyboardAction> actionSet = new HashSet<>();
    private final ElementManager em = ElementManager.getEM();

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            KeyboardAction action = KeyboardAction.toAction(e.getKeyCode());
            if(actionSet.contains(action))
                return;
            actionSet.add(action);
            for(ElementObj ele : em.getExtraEMData(GameElement.PLAYER)) {
                ele.handleKeyboardAction(true, action);
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            KeyboardAction action = KeyboardAction.toAction(e.getKeyCode());
            actionSet.remove(action);
            for (ElementObj ele : em.getExtraEMData(GameElement.PLAYER)) {
                ele.handleKeyboardAction(false, action);
            }
        } catch (Exception ignored) {}
    }
}
