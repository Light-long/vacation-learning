package com.tx.create.factory.abstractfactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(Factory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }
}
