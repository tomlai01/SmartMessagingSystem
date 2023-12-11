package App.Feature;

import App.App;
import App.View.Terminal;
import App.Utils.*;

import java.util.ArrayList;
import java.util.HashSet;

public class ConversationManager extends Feature {

    HashSet<Conversation> mutedConversation = new HashSet<>();

    public ConversationManager(App app) {
        super(app);
    }

    public void createConversation(App app, String[] command) {
        HashSet<Profile> participants = new HashSet<>();
        participants.add(app.user);
        for (int i = 1; i < command.length; i++) {
            Profile participant = app.contactSearch.getContact(command[i]);
            if (participant == null) {
                Terminal.terminalInfo(app.user.getName(),"You have no contact named "+command[i]);
                return;
            }
            if (app.contactManager.contactBlocked.contains(participant)) {
                Terminal.terminalInfo(app.user.getName(),"Conversation can't be created with blocked profiles");
                return;
            }
            participants.add(participant);
        }
        Conversation conversation = new Conversation(participants);
        app.server.createConversation(conversation);
        app.conversations.add(conversation);
        Terminal.terminalInfo(app.user.getName(),"conversation "+ conversation.getName()+" successfully created");
    }

    public void leaveConversation(App app, String[] command) {
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        app.conversations.remove(conversation);
    }

    public void showConversationList(App app, String[] command) {
        String info = "conversation List :";
        for (Conversation conversation : app.conversations) {
            info += "\n- " + conversation.getName();
        }
        Terminal.terminalInfo(app.user.getName(),info);
    }

    public void addParticipants(App app, String[] command) {
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        ArrayList<Profile> participants = new ArrayList<>();
        for (int i = 2; i < command.length; i++) {
            Profile participant = app.contactSearch.getContact(command[i]);
            if (participant == null) {
                Terminal.terminalInfo(app.user.getName(),"You have no contact named "+command[i]);
                return;
            } else {
                participants.add(participant);
            }
        }
        conversation.participants.addAll(participants);
        Terminal.terminalInfo(app.user.getName(),participants+" has successfully been added to the conversation "+ conversation.getName());
    }

    public void removeParticipants(App app, String[] command) {
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        ArrayList<Profile> participants = new ArrayList<>();
        for (int i = 2; i < command.length; i++) {
            Profile participant = app.contactSearch.getContact(command[i]);
            if (conversation.participants.contains(participant)) {
                participants.add(participant);
            }
        }
        conversation.participants.removeAll(participants);
        Terminal.terminalInfo(app.user.getName(),participants + " has successfully been removed from the conversation "+ conversation.getName());
    }

    public void renameConversation(App app, String[] command) {
        if (command.length != 3) {
            Terminal.terminalInfo(app.user.getName(),"renameConversation gets 3 arguments, you gave "+command.length+" arguments");
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        String oldName = conversation.getName();
        conversation.setName(command[2]);
        Terminal.terminalInfo(app.user.getName(),"The conversation "+oldName+" has been renamed into "+command[2]);
    }

    public void readConversation(App app, String[] command) {
        if (command.length != 2) {
            Terminal.terminalInfo(app.user.getName(),"readConversation gets 2 arguments, you gave "+command.length+" arguments");
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        String info = "Messages from "+conversation.getName()+" :\n"+conversation;
        Terminal.terminalInfo(app.user.getName(),info);
        app.voiceReader.apply(info);
       }

    public void muteConversation(App app, String[] command) {
        if (command.length != 2) {
            Terminal.terminalInfo(app.user.getName(),"muteConversation gets 2 arguments, you gave "+command.length+" arguments");
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        mutedConversation.add(conversation);
        Terminal.terminalInfo(app.user.getName(), command[1]+" has been muted");
    }

    public void unmuteConversation(App app, String[] command) {
        if (command.length != 2) {
            Terminal.terminalInfo(app.user.getName(),"unmuteConversation gets 2 arguments, you gave "+command.length+" arguments");
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation == null) {
            Terminal.terminalInfo(app.user.getName(),"You have no conversation with the name " + command[1]);
            return;
        }
        if (!mutedConversation.contains(conversation)) {
            Terminal.terminalInfo(app.user.getName(),command[1]+" is not muted");
            return;
        }
        mutedConversation.remove(conversation);
        Terminal.terminalInfo(app.user.getName(), command[1]+" has been unmuted");
    }
}
