package Server;

import App.App;
import App.Utils.Conversation;
import App.Utils.Message;
import App.Utils.Packet;
import App.Utils.Profile;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Server {

    HashMap<Profile, HashSet<Conversation>> conversations;
    HashMap<String, Profile> profiles;
    HashMap<Profile, App> apps;

    public Server() {
        conversations = new HashMap<>();
        profiles = new HashMap<>();
        apps = new HashMap<>();
    }

    public Server(HashMap<Profile, HashSet<Conversation>> conversations, HashMap<String, Profile> profiles) {
        this.conversations = conversations;
        this.profiles = profiles;
        apps = new HashMap<>();
    }

    public Profile getProfile(String name) {
        return profiles.get(name);
    }

    public void addApps(HashMap<Profile, App> apps) {
        this.apps.putAll(apps);
    }

    public Profile connect(String phoneNumber, App app) {
        if (!profiles.containsKey(phoneNumber)) {
            Profile profile = new Profile(phoneNumber);
            profiles.put(phoneNumber, profile);
            Terminal.serverInfo("Profile "+phoneNumber+" created");
            apps.put(profile, app);
            conversations.put(profile, new HashSet<>());
            return profiles.get(phoneNumber);
        }
        apps.put(profiles.get(phoneNumber), app);
        Terminal.serverInfo("Profile "+phoneNumber+" connected");
        return profiles.get(phoneNumber);
    }

    public HashSet<Conversation> getConversations(Profile profile) {
        return conversations.getOrDefault(profile, new HashSet<>());
    }

    public void setPseudo(String oldPseudo, String newPseudo) {
        Profile profile = profiles.get(oldPseudo);
        profiles.remove(oldPseudo);
        profiles.put(newPseudo, profile);
        Terminal.serverInfo(oldPseudo+" has been renamed into "+newPseudo);
    }

    public void createConversation(Conversation conversation) {
        for (Profile participant:conversation.participants) {
            conversations.get(participant).add(conversation);
        }
        Terminal.serverInfo("Conversation synchronized with the server");
    }

    public void addContact(Profile adder, HashSet<Profile> contacts) {
        HashSet<Profile> newContact = new HashSet<>();
        newContact.add(adder);
        for (Profile contact:contacts) {
            contact.addContacts(newContact);
        }
    }

    public void removeContact(Profile remover, HashSet<Profile> contacts) {
        HashSet<Profile> newContact = new HashSet<>();
        newContact.add(remover);
        for (Profile contact:contacts) {
            contact.removeContacts(newContact);
        }
    }

    public void deliverMessage(Packet packet) {
        Terminal.serverInfo("Delivery of message from "+packet.message.sender+" to the participants of the conversation "+packet.conversation.getName());
        packet.conversation.addMessage(packet.message); //add the message in the conversation
        //notify every participant
        for (Profile participant:packet.conversation.participants) {
            App app = apps.getOrDefault(participant, null);
            if (app != null) {
                apps.get(participant).networkManager.handlePacket(packet);
            }
        }
    }

    public void simulation(App app, String[] command){
        if (command.length < 4) {
            Terminal.serverInfo("sendMessage command requires the conversation and the message to send");
            return;
        }
        Profile profile = getProfile(command[1]);
        if (profile == null) {
            Terminal.serverInfo("There is no profile named "+command[1]);
            return;
        }
        Conversation conversation = app.conversationSearch.getConversation(command[2]);
        if (conversation== null) {
            Terminal.serverInfo("You don't have conversation named "+command[2]);
            return;
        }
        Message message = new Message(profile, new Timestamp(System.currentTimeMillis()), String.join(" ", Arrays.copyOfRange(command,3,command.length)));
        deliverMessage(new Packet(conversation, message));
    }
}
