package org.yyym.model.manager;

import org.yyym.controller.action.KeyboardAction;

import java.util.List;

/**
 * @tip 这个枚举会展示所有的在本游戏出现的元素,
 *      只有在本枚举中定义的key才能在{@link org.yyym.model.manager.ElementManager}中获取,
 *      绘画的顺序就是声明的顺序
 * @enumElement MAP: 地图
 * @enumElement PLAYER: 玩家
 * @enumElement BOMB: 炸弹
 * @enumElement BARRIER: 不可摧毁障碍物
 * @enumElement Destructible1: 一次即可摧毁的障碍物
 */
public enum GameElement {
    PLAYER1() {
        @Override
        public List<KeyboardAction> actions() {
            return List.of(KeyboardAction.BOTTOM_S, KeyboardAction.LEFT_A,
                KeyboardAction.RIGHT_D, KeyboardAction.TOP_W);
        }
    }, PLAYER2() {
        @Override
        public List<KeyboardAction> actions() {
            return List.of(KeyboardAction.BOTTOM, KeyboardAction.LEFT,
                    KeyboardAction.RIGHT, KeyboardAction.TOP);
        }
    };
    public abstract List<KeyboardAction> actions();
    public static List<GameElement> getPlayer() {
        return List.of(GameElement.PLAYER1, GameElement.PLAYER2);
    }
}
