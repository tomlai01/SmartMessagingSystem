package App.Feature.ActivableFeature;

import App.App;

public class Mute extends ActivableFeature{


    public Mute(App app) {
        super(app);
        activate = false;
        featureName = "Mute";
    }

    @Override
    void restrict() {
        app.ring.disable();
        app.vibrator.disable();
    }

    @Override
    public void apply(String information) {
        System.out.println("----- "+app.user.getName()+" IS MUTED -----");
    }
}
