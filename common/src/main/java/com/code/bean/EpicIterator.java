package com.code.bean;
import com.code.pojo.Epic;
import java.util.List;

public class EpicIterator {

    private final static EpicIterator INSTANCE = new EpicIterator();   //用于引用全局唯一的单例对象，在一开始就创建好

    private EpicIterator() {}   //不允许随便new，需要对象直接找getInstance

    public static EpicIterator getInstance(){  //获取全局唯一的单例对象
        return INSTANCE;
    }

    private List<Epic> epicList;
    private int position = 0;

    public void setEpicList(List<Epic> epicList) {
        this.epicList = epicList;
    }

    public boolean hashNext(){
        return position<epicList.size();
    }
    public Epic next(){
        Epic epic = epicList.get(position);
        position++;
        return epic;
    }
}
