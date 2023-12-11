package App.Feature;

import App.App;
import App.Utils.Profile;
import App.View.Terminal;

import java.util.HashSet;

public class ContactManager extends Feature {

    HashSet<Profile> contacts;

    public ContactManager(App app) {
        super(app);
    }

    public void addContacts(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo(app.user.getName(),"You have not typed contacts after the addContact command");
            return;
        }
        HashSet<Profile> contacts = new HashSet<>();
        for (int i = 1; i < command.length; i++) {
            Profile contact = app.server.getProfile(command[i]);
            if (contact == null) {
                Terminal.terminalInfo(app.user.getName(),"The profile named "+command[i]+" doesn't exist");
                return;
            }
            contacts.add(contact);
        }
        app.user.addContacts(contacts);
        app.server.addContact(app.user, contacts);
    }

    public void removeContacts(App app, String[] command) {
        if (command.length < 2) {
            Terminal.terminalInfo(app.user.getName(),"You have not typed contacts after the removeContact command");
            return;
        }
        HashSet<Profile> contacts = new HashSet<>();
        for (int i = 1; i < command.length; i++) {
            Profile contact = app.contactSearch.getContact(command[i]);
            if (contact == null) {
                Terminal.terminalInfo(app.user.getName(),"You have no contact named "+command[i]);
                return;
            }
            contacts.add(contact);
        }
        app.user.addContacts(contacts);
        app.server.removeContact(app.user, contacts);
    }

    public void showContactList(App app, String[] command) {
        String info = "Contact List :";
        for (Profile contact: app.user.getContacts()) {
            info += "\n- " + contact.getName();
        }
        Terminal.terminalInfo(app.user.getName(),info);
    }
}
