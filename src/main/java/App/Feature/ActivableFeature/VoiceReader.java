package App.Feature.ActivableFeature;

import App.App;

public class VoiceReader extends ActivableFeature{

    public VoiceReader(App app) {
        super(app);
        activate = false;
        featureName = "Voice reading";
    }

    @Override
    void restrict() {}

    @Override
    public void apply(String information) {
        if (activate) {
            System.out.println("----- "+app.user.getName()+" VOICE READING -----"+"\n"+information+"----------------------------");
        }
    }
}
