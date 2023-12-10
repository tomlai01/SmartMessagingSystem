package App.Feature;

import App.App;
import App.Utils.Discussion;

public class DiscussionSearch extends Feature{
    public DiscussionSearch(App app) {
        super(app);
    }

    Discussion getDiscussion(String discussionName) {
        for (Discussion discussion:app.discussions) {
            if (discussion.getName().equals(discussionName)) {
                return discussion;
            }
        }
        return null;
    }
}
