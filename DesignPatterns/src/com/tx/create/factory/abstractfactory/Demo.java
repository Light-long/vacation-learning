package com.tx.create.factory.abstractfactory;

public class Demo {
    private static Application configureApplication() {
        Application app;
        Factory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.equals("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WinFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
