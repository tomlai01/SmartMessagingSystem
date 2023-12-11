package App.Feature.ActivableFeature;

import App.App;

public class Ring extends ActivableFeature{

    public Ring(App app) {
        super(app);
        activate = true;
        featureName = "Ring";
    }

    @Override
    void restrict() {
        app.mute.disable();
    }

    @Override
    public void apply(String information) {
        System.out.println("----- "+app.user.getName()+" RINGING -----");
    }
}
