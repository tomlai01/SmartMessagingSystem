package App.Feature;

import App.App;
import App.Utils.Conversation;
import App.Utils.Message;
import App.Utils.Packet;
import App.View.Terminal;

import java.sql.Timestamp;
import java.util.Arrays;

public class NetworkManager extends Feature {

    public NetworkManager(App app) {
        super(app);
    }

    public void sendMessage(App app, String[] command) {
        if (command.length < 3) {
            Terminal.terminalInfo(app.user.getName(),"sendMessage command requires the conversation and the message to send");
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[1]);
        if (conversation== null) {
            Terminal.terminalInfo(app.user.getName(),"You don't have conversation named "+command[1]);
            return;
        }
        Message message = new Message(app.user, new Timestamp(System.currentTimeMillis()), String.join(" ", Arrays.copyOfRange(command,2,command.length)));
        app.server.deliverMessage(new Packet(conversation, message));
    }


    public void handlePacket(Packet packet) {
        if (!app.contactManager.contactMuted.contains(packet.message.sender)
                && !app.contactManager.contactBlocked.contains(packet.message.sender)
                && !app.conversationManager.mutedConversation.contains(packet.conversation)
                && !app.switchableFeatureManager.availableStatus.getState().equals("Occupied")
                && !app.switchableFeatureManager.availableStatus.getState().equals("Disconnected")) {
            if (packet.message.sender != app.user) {
                notify(packet);
            }
        }
    }

    private void notify(Packet packet) {
        app.ring.apply("");
        app.vibrator.apply("");
        Terminal.terminalInfo(app.user.getName(), "New message by "+packet.message.sender+" from "+packet.conversation.getName());
    }
}
