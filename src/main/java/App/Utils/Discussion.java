package App.Utils;

import App.Terminal;

import java.util.ArrayList;

public class Discussion {
    public String name;
    public ArrayList<Profile> participants;
    ArrayList<Message> messages;

    public Discussion(ArrayList<Profile> participants) {
        this.participants = participants;
    }

    public String getName() {
        if (this.name == null) {
            return this.participants.toString();
        }
        return name;
    }

    void setName(String name) {
        String oldName = this.getName();
        this.name = name;
        String info = "The conversation "+oldName+" has been successfully renamed to "+this.getName();
        Terminal.terminalInfo(info);
    }

    boolean addParticipant(Profile participant) {
        if (this.participants.contains(participant)) {
            return false;
        }
        this.participants.add(participant);
        String info = "The participant "+participant.getName()+" has been successfully added to "+this.getName();
        Terminal.terminalInfo(info);
        return true;
    }

    boolean removeParticipant(Profile participant) {
        if (!this.participants.contains(participant)) {
            return false;
        }
        this.participants.remove(participant);
        String info = "The participant "+participant.getName()+" has been successfully removed to "+this.getName();
        Terminal.terminalInfo(info);
        return true;
    }
}
