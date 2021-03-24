package com.tx.compare;

public class Goods implements Comparable{
    private String name;
    private double price;

    // 商品比较大小的方式
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            // 价格从低到高
            if (this.price > goods.price) {
                return 1;
            } else if (this.price == goods.price) {
                // 名称升序
                return this.name.compareTo(goods.name);
                // 降序
                // return - this.name.compareTo(goods.name);
            } else {
                return -1;
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }

    public Goods() {}

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
