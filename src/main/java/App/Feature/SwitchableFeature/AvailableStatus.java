package App.Feature.SwitchableFeature;

import App.App;

public class AvailableStatus extends SwitchableFeature{
    public AvailableStatus(App app) {
        super(app);
        currentState = "Available";
        possibleState.add("Available");
        possibleState.add("Occupied");
        possibleState.add("Disconnected");
        featureName = "AvailableStatus";
    }
}
