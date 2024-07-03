package org.yyym.model.manager;

import lombok.Getter;
import org.yyym.model.ElementObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @tip 本类为Model中的元素管理器,主要是用来存储元素,支持view层读取数据,controller层读写数据,本类为单例
 */
public class ElementManager {
    @Getter
    private final static ElementManager EM = new ElementManager();

    @Getter
    private final Map<GameElement, List<ElementObj>> EMData = new HashMap<>();

    /**
     * @tip 指定key返回对应的元素数据集合
     * @param ele: 获取对应游戏元素的key， 存在的key可以在{@link org.yyym.model.manager.GameElement}中查看
     * @return 返回对应游戏元素所包含的数据, 返回类型为基类 {@link org.yyym.model.ElementObj}
     */
    public List<ElementObj> getExtraEMData(GameElement ele) {
        return this.EMData.get(ele);
    }

    /**
     * @tip 添加元素(多半由加载器调用) 指定key和要添加的元素
     * @param ele 对应游戏元素的key， 存在的key可以在{@link org.yyym.model.manager.GameElement}中查看
     * @param data 要添加的对应的数据
     */
    public void addExtraEMData(GameElement ele, ElementObj data) {
        this.EMData.get(ele).add(data);
    }
    private ElementManager() {
        this.initEM();
    }
    /**
     * @tip 将来可能出现的功能扩展, 可以重写此方法实现, 本方法主要是初始化List
     */
    public void initEM() {
        for (GameElement ele : GameElement.values())
            EMData.put(ele, new ArrayList<>());
    }
}
