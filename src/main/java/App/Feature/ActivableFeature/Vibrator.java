package App.Feature.ActivableFeature;

import App.App;

public class Vibrator extends ActivableFeature{


    public Vibrator(App app) {
        super(app);
        activate = true;
        featureName = "Vibrator";
    }

    @Override
    void restrict(){
        app.mute.disable();
    }

    @Override
    public void apply(String information) {
        System.out.println("----- "+app.user.getName()+" VIBRATING -----");
    }
}
