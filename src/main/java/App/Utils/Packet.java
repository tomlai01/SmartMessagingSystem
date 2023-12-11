package App.Utils;

public class Packet {
    public Conversation conversation;
    public Message message;

    public Packet(Conversation conversation, Message message) {
        this.conversation = conversation;
        this.message = message;
    }
}
