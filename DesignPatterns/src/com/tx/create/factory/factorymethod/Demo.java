package com.tx.create.factory.factorymethod;

public class Demo {
    private static Factory factory;

    public static void main(String[] args) {
        configure();
        runLogic();
    }

    public static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            factory = new WinButtonFactory();
        } else {
            factory = new HtmlFactory();
        }
    }

    public static void runLogic() {
        factory.renderButton();
    }
}
