package App.Feature;

import App.App;
import App.Terminal;
import App.Utils.Discussion;
import App.Utils.Profile;

import java.util.ArrayList;

public class DiscussionManager extends Feature {

    public DiscussionManager(App app) {
        super(app);
    }

    public void createDiscussion(ArrayList<Profile> participants) {
        Discussion discussion = new Discussion(participants);
        app.discussions.add(discussion);
        Terminal.terminalInfo("Discussion \""+discussion.getName()+"\" successfully created");
    }

    public boolean addParticipant(String discussionName, Profile participant) {
        Discussion discussion = app.discussionSearch.getDiscussion(discussionName);
        if (discussion != null) {
            discussion.participants.add(participant);
            Terminal.terminalInfo(participant.getName()+" has successfully been added to the discussion "+"\""+discussionName+"\"");
            return true;
        }
        Terminal.terminalInfo("Can't find discussion " + "\""+discussionName+"\"");
        return false;
    }

    public boolean removeParticipant(String discussionName, Profile participant) {
        Discussion discussion = app.discussionSearch.getDiscussion(discussionName);
        if (discussion != null) {
            discussion.participants.remove(participant);
            Terminal.terminalInfo(participant.getName()+" has successfully been removed from the discussion "+"\""+discussionName+"\"");
            return true;
        }
        Terminal.terminalInfo("Can't find discussion " + "\""+discussionName+"\"");
        return false;
    }

    public boolean removeDiscussion(String discussionName) {
        Discussion discussion = app.discussionSearch.getDiscussion(discussionName);
        if (discussion != null) {
            app.discussions.remove(discussion);
            Terminal.terminalInfo(discussionName+" has successfully been removed");
            return true;
        }
        Terminal.terminalInfo("Can't find discussion " + "\""+discussionName+"\"");
        return false;
    }

}
