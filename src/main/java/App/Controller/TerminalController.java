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
                case "muteContacts":
                    app.contactManager.muteContacts(app, command);
                    break;
                case "unmuteContacts":
                    app.contactManager.unmuteContacts(app, command);
                    break;
                case "blockContacts":
                    app.contactManager.blockContacts(app, command);
                    break;
                case "unblockContacts":
                    app.contactManager.unblockContacts(app, command);
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
                case "muteConversation":
                    app.conversationManager.muteConversation(app, command);
                    break;
                case "unmuteConversation":
                    app.conversationManager.unmuteConversation(app, command);
                    break;
                case "activateRing":
                    app.ring.activate();
                    break;
                case "disableRing":
                    app.ring.disable();
                    break;
                case "activateVibrator":
                    app.vibrator.activate();
                    break;
                case "disableVibrator":
                    app.vibrator.disable();
                    break;
                case "mute":
                    app.mute.activate();
                    break;
                case "sendMessage":
                    app.networkManager.sendMessage(app, command);
                    break;
                case "otherAppSendMessage":
                    app.server.simulation(app, command);
                    break;
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
