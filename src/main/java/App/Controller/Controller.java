package App.Controller;

import App.App;

public abstract class Controller {

    App app;
    Controller(App app) {
        this.app = app;
    }

    abstract public void connect();

    abstract public void run();
}
