package App.Feature;

import App.App;
import App.Utils.Profile;

public class ContactSearch extends Feature{
    public ContactSearch(App app) {
        super(app);
    }

    public Profile getContact(String profileName) {
        for (Profile contact: app.contacts) {
            if (contact.getName().equals(profileName)) {
                return contact;
            }
        }
        return null;
    }
}
