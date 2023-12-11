package App.View;

public class Terminal {

    static public void terminalInfo(String name, String info) {
        System.out.println("===== "+name+" TERMINAL INFO =====\n"+info+"\n");
    }

    static public void startInfo() {
        String info =
                "Application has been successfully started.\n" +
                "Waiting for command ...\n" +
                "Type help to get the possible commands.";
        terminalInfo("Controller",info);
    }

    static public void unknownCommandInfo() {
        String info =
                "You have entered an unknown command.\n" +
                "Type help to get the possible commands.";
        terminalInfo("Controller",info);
    }

    static public void waitingForCommand() {
        String info =
                "Waiting for command ...\n" +
                "Type help to get the possible commands.";
        terminalInfo("Controller",info);
    }

    static public void helpInfo() {
        String info =
                "- setProfileName <profileName> : set your profile name\n" +
                "- showProfileName : show your profile name\n" +
                "- addContacts <contactName> ... <contactNameN> : add contacts in your contact list\n" +
                "- removeContacts <contactName1> ... <contactNameN> : remove contacts from your contact list\n" +
                "- createDiscussion <participant1> ... <participantN> : create a new discussion\n" +
                "- leaveConversation <discussionName> : leave a conversation\n" +
                "- addParticipants <discussionName> <participant1> ... <participantN> : add participants in a discussion\n" +
                "- removeParticipants <discussionName> <participant1> ... <participantN> : remove participants from a discussion\n" +
                "- showDiscussionList : show the list of you discussions\n" +
                "- sendMessage <discussionName> <type> <message> : show the list of you discussions\n" +
                "- renameConversation <discussionName> <newName> : rename a conversation\n" +
                "- quit : quit the application";
        terminalInfo("Controller",info);
    }


}
