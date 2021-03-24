package com.tx.create.factory.factorymethod;

public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("I am html button");
    }

    @Override
    public void onClick() {
        System.out.println("click the html button");
    }
}
