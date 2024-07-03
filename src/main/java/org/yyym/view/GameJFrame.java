package org.yyym.view;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.Optional;

@Setter
public class GameJFrame extends JFrame {
    public static int GAME_WIDTH = 900;
    public static int GAME_HEIGHT = 600;
    private JPanel jPanel;
    private KeyListener keyListener;
    private Thread thread;

    public GameJFrame() {
        this.initJFrame();
    }
    public void initJFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT); //设置窗体大小
        this.setTitle("测试游戏-泡泡堂");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置退出并且关闭
        this.setLocationRelativeTo(null);//屏幕居中显示
    }
    public void start() {
        if(jPanel != null) this.add(jPanel);
        if(keyListener != null) this.addKeyListener(keyListener);
        if(thread != null) thread.start();
        this.setVisible(true);
    }
}
