package App.Feature.SwitchableFeature;

import App.App;
import App.Feature.Feature;
import App.View.Terminal;

import java.util.HashSet;

public abstract class SwitchableFeature extends Feature {

    String currentState;
    HashSet<String> possibleState = new HashSet<>();
    String featureName;

    protected SwitchableFeature(App app) {
        super(app);
    }

    public String getState() {
        return currentState;
    }

    public void switchState(String state){
        if (!possibleState.contains(state)) {
            Terminal.terminalInfo(app.user.getName(), state+" is not a valid state for "+featureName);
            return;
        }
        currentState = state;
        view();
    }

    void view() {
        Terminal.terminalInfo(app.user.getName(), featureName+" is now set to "+currentState);
    }
}
