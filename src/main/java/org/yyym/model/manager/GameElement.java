package org.yyym.model.manager;

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
    MAP, PLAYER, BOMB, BARRIER, Destructible1
}
