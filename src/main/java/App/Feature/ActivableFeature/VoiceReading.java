package App.Feature.ActivableFeature;

import App.App;

public class VoiceReading extends ActivableFeature{

    VoiceReading(App app) {
        super(app);
        activate = false;
        featureName = "Voice reading";
    }

    @Override
    void restrict() {

    }

    @Override
    public void apply(String information) {

    }
}
