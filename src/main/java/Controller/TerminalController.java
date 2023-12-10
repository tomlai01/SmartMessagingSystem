package Controller;

import App.App;
import App.Terminal;
import App.Utils.Profile;
import Controller.Commands.Commands;

import java.util.Scanner;

public class TerminalController extends Controller{

    public TerminalController(App app) {
        super(app);
    }

    @Override
    public void register() {
        Scanner in = new Scanner(System.in);
        Terminal.terminalInfo("Type your phoneNumber :");
        String phoneNumber = in.nextLine();
        app.user = new Profile(phoneNumber);
    }

    public void run() {
        if (this.app.user == null) {
            Terminal.terminalInfo("Unregistered");
        }
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
                    Commands.setProfileName(app, command);
                    break;
                case "createDiscussion":
                    Commands.createDiscussion(app, command);
                    break;
                case "addContact":
                    Commands.addContact(app, command);
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

    public static void main(String[] args) {
        TerminalController controller = new TerminalController(new App());
        controller.register();
        controller.run();
    }


}
