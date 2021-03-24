package com.tx.create.factory.factorymethod;

public class WinButton implements Button{
    @Override
    public void render() {
        System.out.println("I am Win button");
    }

    @Override
    public void onClick() {
        System.out.println("click the Win button");
    }
}
