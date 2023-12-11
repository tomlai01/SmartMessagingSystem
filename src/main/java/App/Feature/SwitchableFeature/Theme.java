package App.Feature.SwitchableFeature;

import App.App;

public class Theme extends SwitchableFeature{
    public Theme(App app) {
        super(app);
        currentState = "Light";
        possibleState.add("Light");
        possibleState.add("Dark");
        featureName = "Theme";
    }


}
