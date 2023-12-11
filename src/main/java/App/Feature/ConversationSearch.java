package App.Feature;

import App.App;
import App.Utils.Conversation;

public class ConversationSearch extends Feature{
    public ConversationSearch(App app) {
        super(app);
    }

    public Conversation getConversation(String ConversationName) {
        for (Conversation conversation :app.conversations) {
            if (conversation.getName().equals(ConversationName)) {
                return conversation;
            }
        }
        return null;
    }
}
