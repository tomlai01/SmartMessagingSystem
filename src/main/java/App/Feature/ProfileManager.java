package App.Feature;

import App.App;
import App.View.Terminal;

public class ProfileManager extends Feature {
    public ProfileManager(App app) {
        super(app);
    }

    public void setProfileName(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo(app.user.getName(),"You have not type a profile name after the setProfileName command");
            return;
        }
        String oldPseudo = app.user.getName();
        app.server.setPseudo(oldPseudo, command[1]);
        app.user.setPseudo(command[1]);
        Terminal.terminalInfo(app.user.getName(),oldPseudo+" has been renamed into "+command[1]);
    }

    public void showProfileName(App app, String[] command) {
        Terminal.terminalInfo(app.user.getName(),"Your profileName is "+app.user.getName());
    }
}
