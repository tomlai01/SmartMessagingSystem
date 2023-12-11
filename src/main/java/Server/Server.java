package Server;

import App.App;
import App.Utils.Conversation;
import App.Utils.Message;
import App.Utils.Profile;

import java.util.HashMap;
import java.util.HashSet;

public class Server {

    HashMap<Profile, HashSet<Conversation>> conversations;
    HashMap<String, Profile> profiles;
    HashMap<Profile, App> apps = new HashMap<>();

    public Server() {
        conversations = new HashMap<>();
        profiles = new HashMap<>();
    }

    public Server(HashMap<Profile, HashSet<Conversation>> conversations, HashMap<String, Profile> profiles) {
        this.conversations = conversations;
        this.profiles = profiles;
    }

    public Profile getProfile(String name) {
        return profiles.get(name);
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
        //TODO notify contacts
    }

    public void removeContact(Profile remover, HashSet<Profile> contacts) {
        HashSet<Profile> newContact = new HashSet<>();
        newContact.add(remover);
        for (Profile contact:contacts) {
            contact.removeContacts(newContact);
        }
        //TODO notify contacts
    }

    public void deliverMessage(Conversation conversation, Message message) {
        for (Profile participant:conversation.participants) {
            apps.get(participant).notificationManager.notify(conversation, message);
        }
    }
}
