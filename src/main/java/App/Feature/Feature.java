package App.Feature;

import App.App;

public abstract class Feature {
    App app;

    Feature(App app) {
        this.app = app;
    }
}
