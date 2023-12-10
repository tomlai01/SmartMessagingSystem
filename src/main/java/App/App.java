package App;

import App.Feature.ContactManager;
import App.Feature.ContactSearch;
import App.Feature.DiscussionManager;
import App.Feature.DiscussionSearch;
import App.Utils.Discussion;
import App.Utils.Profile;

import java.util.ArrayList;

public class App {

    public Profile user;
    public ArrayList<Profile> contacts = new ArrayList<>();
    public ArrayList<Discussion> discussions = new ArrayList<>();
    public DiscussionManager discussionManager = new DiscussionManager(this);
    public DiscussionSearch discussionSearch = new DiscussionSearch(this);
    public ContactManager contactManager = new ContactManager(this);
    public ContactSearch contactSearch = new ContactSearch(this);

    public App(){
        user = null;
    }
}
