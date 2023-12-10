package App;

public class Terminal {

    static public void terminalInfo(String info) {
        System.out.println("TERMINAL INFO :\n"+info+"\n");
    }

    static public void startInfo() {
        String info =
                "Application has been successfully started.\n" +
                "Waiting for command ...\n" +
                "Type help to get the possible commands.";
        terminalInfo(info);
    }

    static public void unknownCommandInfo() {
        String info =
                "You have entered an unknown command.\n" +
                "Type help to get the possible commands.";
        terminalInfo(info);
    }

    static public void waitingForCommand() {
        String info =
                "Waiting for command ...\n" +
                "Type help to get the possible commands.";
        terminalInfo(info);
    }

    static public void helpInfo() {
        String info =
                "- setProfileName <profileName> : set your profile name\n" +
                "- addContact <contactName> : add contact in your contact list\n" +
                "- createDiscussion <participant1> <participant2> ... <participantN> : create a new discussion\n" +
                "- quit : quit the application";
        terminalInfo(info);
    }


}
