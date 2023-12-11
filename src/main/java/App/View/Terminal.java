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

    static public void helpInfo() {
        String info =
                "- setProfileName <profileName> : set your profile name\n" +
                "- showProfileName : show your profile name\n" +
                "- addContacts <contactName> ... <contactNameN> : add contacts in your contact list\n" +
                "- removeContacts <contactName1> ... <contactNameN> : remove contacts from your contact list\n" +
                "- muteContacts <contactName1> ... <contactNameN> : mute contacts from your contact list; you don't receive notification anymore from them\n" +
                "- unmuteContacts <contactName1> ... <contactNameN> : unmute contacts previously muted\n" +
                "- blockContacts <contactName1> ... <contactNameN> : block contacts from your contact list; these contacts are muted and can't create conversation with you\n" +
                "- unblockContacts <contactName1> ... <contactNameN> : unblock contacts previously blocked\n" +
                "- createConversation <participant1> ... <participantN> : create a new conversation\n" +
                "- leaveConversation <conversationName> : leave a conversation\n" +
                "- readConversation <conversationName> : read a conversation\n" +
                "- muteConveration <conversationName> : mute the conversation; you don't receive notification anymore from this conversation\n" +
                "- unmuteConveration <conversationName> : unmute the conversation previously muted\n" +
                "- addParticipants <conversationName> <participant1> ... <participantN> : add participants in a conversation\n" +
                "- removeParticipants <conversationName> <participant1> ... <participantN> : remove participants from a conversation\n" +
                "- showConversationList : show the list of you conversations\n" +
                "- sendMessage <conversationName> <type> <message> : show the list of you conversations\n" +
                "- renameConversation <conversationName> <newName> : rename a conversation\n" +
                "- activateRing : active ring\n" +
                "- disableRing : disable ring\n" +
                "- activateVibrator : disable vibrator\n" +
                "- disableVibrator : disable vibrator\n" +
                "- disableVoiceReader : disable voice reader\n" +
                "- activateVoiceReader : activate voice reader\n" +
                "- switchAvailableStatus <status> : switch the available status; possible status : [Available, Occupied, Disconnected]\n" +
                "- switchTheme <status> : switch the theme; possible themes : [Light, Dark]\n" +
                "- mute : mute the app\n" +
                "- quit : quit the application";
        terminalInfo("Controller",info);
    }


}
