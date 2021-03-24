package com.tx.create.factory.factorymethod;

public class WinButtonFactory extends Factory{
    @Override
    public Button createButton() {
        return new WinButton();
    }
}
