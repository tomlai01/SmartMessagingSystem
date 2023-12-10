package Controller.Commands;

import App.App;
import App.Terminal;
import App.Utils.Profile;

import java.util.ArrayList;

public class Commands {

    static public void setProfileName(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo("You have not type a profile name after the setProfileName command");
            return;
        }
        app.user.setPseudo(command[1]);
    }
    static public void createDiscussion(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo("You have not type a contact name after the createDiscussion command");
            return;
        }
        ArrayList<Profile> participantsList = new ArrayList<>();
        for (int i = 1; i < command.length; i++) {
            Profile participant = app.contactSearch.getContact(command[i]);
            if (participant != null) {
                participantsList.add(participant);
            } else {
                Terminal.terminalInfo("A participant is not in your contacts.\n" +
                        "Type back to back to the main menu.");
            }
        }
        app.discussionManager.createDiscussion(participantsList);
    }

    static public void addContact(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo("You have not type a contact after the addContact command");
            return;
        }
        app.contactManager.addContact(new Profile(command[1]));
    }
}
