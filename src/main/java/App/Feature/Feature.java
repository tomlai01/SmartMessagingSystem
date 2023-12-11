package App.Feature;

import App.App;

public abstract class Feature {
    protected App app;

    protected Feature(App app) {
        this.app = app;
    }


}
