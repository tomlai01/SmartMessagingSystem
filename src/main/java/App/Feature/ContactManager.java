package App.Feature;

import App.App;
import App.Terminal;
import App.Utils.Profile;

import java.util.HashSet;

public class ContactManager extends Feature {

    HashSet<Profile> contacts;

    public ContactManager(App app) {
        super(app);
    }

    public void addContact(Profile contact) {
        app.contacts.add(contact);
        Terminal.terminalInfo("Contact \""+contact.getName()+"\" successfully added");
    }
}
