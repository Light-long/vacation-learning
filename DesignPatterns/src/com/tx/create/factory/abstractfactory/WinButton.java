package com.tx.create.factory.abstractfactory;

public class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("Win Button");
    }
}
