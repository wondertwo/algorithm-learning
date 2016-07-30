package me.wondertwo.ctci145;

/**
 * 
 * Created by Allenieo on 2016/4/29.
 */
public abstract class Animal {

    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlder(Animal animal) {
        return this.order < animal.getOrder();
    }
}
