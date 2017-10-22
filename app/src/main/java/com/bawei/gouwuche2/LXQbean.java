package com.bawei.gouwuche2;

/**
 * Created by Administrator on 2017/10/20.
 */

public class LXQbean {
    private String name;
    private int price;
    private boolean b;

    public LXQbean(String name, int price, boolean b) {
        this.name = name;
        this.price = price;
        this.b = b;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "LXQbean{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", b=" + b +
                '}';
    }
}
