package App.Controller;

import App.App;
import App.View.Terminal;

import java.util.Scanner;

public class TerminalController extends Controller{

    public TerminalController(App app) {
        super(app);
    }

    @Override
    public void connect() {
        Scanner in = new Scanner(System.in);
        Terminal.terminalInfo("Controller", "Type your phoneNumber :");
        String phoneNumber = in.nextLine();
        app.user = app.server.connect(phoneNumber, app);
        app.conversations = app.server.getConversations(app.user);
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        Terminal.startInfo();
        String[] command = in.nextLine().split(" ");
        while (!quit) {
            switch (command[0]) {
                case "help":
                    Terminal.helpInfo();
                    break;
                case "setProfileName":
                    app.profileManager.setProfileName(app, command);
                    break;
                case "showProfileName":
                    app.profileManager.showProfileName(app, command);
                    break;
                case "addContact":
                    app.contactManager.addContacts(app, command);
                    break;
                case "removeContact":
                    app.contactManager.removeContacts(app, command);
                    break;
                case "showContactList":
                    app.contactManager.showContactList(app, command);
                    break;
                case "createConversation":
                    app.conversationManager.createConversation(app, command);
                    break;
                case "leaveConversation":
                    app.conversationManager.leaveConversation(app, command);
                    break;
                case "showConversationList":
                    app.conversationManager.showConversationList(app, command);
                    break;
                case "addParticipants":
                    app.conversationManager.addParticipants(app, command);
                    break;
                case "removeParticipants":
                    app.conversationManager.removeParticipants(app, command);
                    break;
                case "renameConversation":
                    app.conversationManager.renameConversation(app, command);
                    break;
                case "readConversation":
                    app.conversationManager.readConversation(app, command);
                    break;
//                case "sendMessage":
//                    Commands.sendMessage(app, command);
//                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    Terminal.unknownCommandInfo();
            }
            if (!quit) {
                command = in.nextLine().split(" ");
            }
        }
    }
}
