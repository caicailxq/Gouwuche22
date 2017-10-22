package com.bawei.gouwuche2;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public class EventBean {

    private boolean is_all;
    private List<LXQbean> list;

    @Override
    public String toString() {
        return "EventBean{" +
                "is_all=" + is_all +
                ", list=" + list +
                '}';
    }

    public boolean is_all() {
        return is_all;
    }

    public void setIs_all(boolean is_all) {
        this.is_all = is_all;
    }

    public List<LXQbean> getList() {
        return list;
    }

    public void setList(List<LXQbean> list) {
        this.list = list;
    }

    public EventBean(boolean is_all, List<LXQbean> list) {

        this.is_all = is_all;
        this.list = list;
    }
}
