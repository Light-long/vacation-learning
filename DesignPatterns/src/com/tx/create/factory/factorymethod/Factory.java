package com.tx.create.factory.factorymethod;

public abstract class Factory {

    public abstract Button createButton();

    public void renderButton() {
        //other code
        Button button = createButton();
        button.render();
    }
}
