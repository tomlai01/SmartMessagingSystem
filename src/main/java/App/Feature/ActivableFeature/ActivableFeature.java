package App.Feature.ActivableFeature;

import App.App;
import App.Feature.Feature;
import App.View.Terminal;

public abstract class ActivableFeature extends Feature {

    boolean activate;
    String featureName;

    ActivableFeature(App app) {
        super(app);
    }

    public boolean isActive() {
        return activate;
    }

    public void activate() {
        restrict();
        view("activated");
        activate = true;
    }

    public void disable() {
        view("disabled");
        activate = false;
    }

    abstract void restrict();


    public abstract void apply(String information);

    void view(String info) {
        Terminal.terminalInfo(app.user.getName(), featureName+" "+info);
    }
}
