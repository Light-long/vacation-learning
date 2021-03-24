package com.tx.create.factory.factorymethod;

public class HtmlFactory extends Factory{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
