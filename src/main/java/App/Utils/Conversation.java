package App.Utils;

import java.util.ArrayList;
import java.util.HashSet;

public class Conversation {
    String name;
    public HashSet<Profile> participants;
    ArrayList<Message> messages = new ArrayList<>();

    public Conversation(){
        this.participants = new HashSet<>();
    }
    public Conversation(HashSet<Profile> participants) {
        this.participants = participants;
    }

    public String getName() {
        if (this.name == null) {
            String name = "[";
            for (Profile participant:participants) {
                name += participant.getName()+",";
            }
            return name.substring(0,name.length()-1)+"]";
        }
        return this.name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setName(String name) {
        String oldName = this.getName();
        this.name = name;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        String str = "";
        for (Message message:messages) {
            str += message;
        }
        return str;
    }
}
