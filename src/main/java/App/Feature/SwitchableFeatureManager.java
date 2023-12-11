package App.Feature;

import App.App;
import App.Feature.SwitchableFeature.AvailableStatus;
import App.Feature.SwitchableFeature.Theme;
import App.View.Terminal;

public class SwitchableFeatureManager extends Feature{

    public Theme theme;
    public AvailableStatus availableStatus;
    public SwitchableFeatureManager(App app) {
        super(app);
        theme = new Theme(app);
        availableStatus = new AvailableStatus(app);
    }

    public void getTheme(){
        Terminal.terminalInfo(app.user.getName(),"The theme is set to "+theme.getState());
    }

    public void getAvailableStatus(){
        Terminal.terminalInfo(app.user.getName(),"The available status is set to "+availableStatus.getState());
    }


    public void switchAvailableStatus(App app, String[] command){
        if (command.length != 2) {
            Terminal.terminalInfo(app.user.getName(),"switchAvailableStatus command gets 2 arguments, you gave "+command.length+" arguments");
            return;
        }
        availableStatus.switchState(command[1]);
    }

    public void switchTheme(App app, String[] command){
        if (command.length != 2) {
            Terminal.terminalInfo(app.user.getName(),"switchTheme command gets 2 arguments, you gave "+command.length+" arguments");
            return;
        }
        theme.switchState(command[1]);
    }


}
