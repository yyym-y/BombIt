package org.yyym.controller.action;

import org.yyym.model.ElementObj;
import org.yyym.view.GameJFrame;

public enum KeyboardAction {
    LEFT_A() {
        @Override
        public void effectMove(ElementObj ele) {
            if(ele.getX() - MOVE_LEN >= 0)
                ele.setX(ele.getX() - MOVE_LEN);
        }
    }, RIGHT_D() {
        @Override
        public void effectMove(ElementObj ele) {
            if(ele.getX() + ele.getWidth() + MOVE_LEN <= GameJFrame.GAME_WIDTH)
                ele.setX(ele.getX() + MOVE_LEN);
        }
    }, TOP_W() {
        @Override
        public void effectMove(ElementObj ele) {
            if(ele.getY() - MOVE_LEN >= 0)
                ele.setY(ele.getY() - MOVE_LEN);
        }
    }, BOTTOM_S() {
        @Override
        public void effectMove(ElementObj ele) {
            if(ele.getY() + ele.getHeight() + MOVE_LEN <= GameJFrame.GAME_HEIGHT)
                ele.setY(ele.getY() + MOVE_LEN);
        }
    };
    public static KeyboardAction toAction(int keyCode) throws Exception {
        return switch (keyCode) {
            case 37 -> LEFT_A;
            case 38 -> TOP_W;
            case 39 -> RIGHT_D;
            case 40 -> BOTTOM_S;
            default -> throw new Exception("undefined KeyboardAction type");
        };
    }

    public abstract void effectMove(ElementObj ele);
    public static final int MOVE_LEN = 10;

}
