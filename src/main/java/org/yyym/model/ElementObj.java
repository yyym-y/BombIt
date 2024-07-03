package org.yyym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yyym.controller.action.KeyboardAction;

import javax.swing.*;
import java.awt.*;

/**
 * @tip 这个类是所有model下元素(不包括manager)的共同基类
 *      在开发新功能的时候定义新的角色或元素类的时候一定要继承这个类
 * */
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class ElementObj {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon icon;
    public abstract void show(Graphics g);
    public synchronized void handleKeyboardAction(Boolean clicking,KeyboardAction action) {}
    public synchronized void elementMove() {}
    public synchronized void modelHandler() {}

}
