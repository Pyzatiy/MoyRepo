package com.company;

public abstract class Car implements IAction{
 @Override
    public void click() {
        System.out.println("lol");
    }

    abstract void move();

}
