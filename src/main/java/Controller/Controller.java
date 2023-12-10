package Controller;

import App.App;

public abstract class Controller {

    App app;
    Controller(App app) {
        this.app = app;
    }

    abstract void register();

    abstract void run();
}
