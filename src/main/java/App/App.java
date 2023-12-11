package App;

import App.Controller.Controller;
import App.Controller.TerminalController;
import App.Feature.ActivableFeature.Mute;
import App.Feature.ActivableFeature.Ring;
import App.Feature.ActivableFeature.Vibrator;
import App.Feature.ActivableFeature.VoiceReader;
import App.Feature.*;
import App.Utils.Conversation;
import App.Utils.Message;
import App.Utils.Profile;
import Server.Server;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public Server server;
    public Controller controller;
    public Profile user;
    public HashSet<Conversation> conversations = new HashSet<>();
    public ProfileManager profileManager = new ProfileManager(this);
    public ConversationManager conversationManager = new ConversationManager(this);
    public ConversationSearch conversationSearch = new ConversationSearch(this);
    public ContactManager contactManager = new ContactManager(this);
    public ContactSearch contactSearch = new ContactSearch(this);
    public NetworkManager networkManager = new NetworkManager(this);
    public SwitchableFeatureManager switchableFeatureManager = new SwitchableFeatureManager(this);
    //Activable features
    public Ring ring = new Ring(this);
    public Vibrator vibrator = new Vibrator(this);
    public Mute mute = new Mute(this);
    public VoiceReader voiceReader = new VoiceReader(this);



    public App(Server server){
        this.server = server;
        this.controller = new TerminalController(this);
    }

    public void run() {
        controller.connect();
        controller.run();
    }

    public static void main(String[] args) {
        //create profiles
        Profile profile1 = new Profile("01");
        Profile profile2 = new Profile("02");
        Profile profile3 = new Profile("03");
        //put them in contact
        HashSet<Profile> contacts1 = new HashSet<>();
        contacts1.add(profile2); contacts1.add(profile3);
        profile1.addContacts(contacts1);
        HashSet<Profile> contacts2 = new HashSet<>();
        contacts2.add(profile1); contacts2.add(profile3);
        profile2.addContacts(contacts2);
        HashSet<Profile> contacts3 = new HashSet<>();
        contacts3.add(profile1); contacts3.add(profile2);
        profile3.addContacts(contacts3);

        HashMap<String, Profile> profiles = new HashMap<>();
        profiles.put("01", profile1);
        profiles.put("02", profile2);
        profiles.put("03", profile3);

        //create a conversation
        HashSet<Profile> participants = new HashSet<>(profiles.values());
        Conversation conversation = new Conversation(participants);
        Message message1 =  new Message(profile1, new Timestamp(System.currentTimeMillis()), "Welcome in this new conversation");
        conversation.addMessage(message1);
            Message message2 =  new Message(profile2, new Timestamp(System.currentTimeMillis()+1000000),"Hi bro, thank you!");
        conversation.addMessage(message2);
        //put the conversation in the profiles
        HashMap<Profile, HashSet<Conversation>> conversations = new HashMap<>();

        HashSet<Conversation> conversationsList01 = new HashSet<>();
        conversationsList01.add(conversation);
        conversations.put(profiles.get("01"), conversationsList01);
        HashSet<Conversation> conversationsList02 = new HashSet<>();
        conversationsList02.add(conversation);
        conversations.put(profiles.get("02"), conversationsList02);
        HashSet<Conversation> conversationsList03 = new HashSet<>();
        conversationsList03.add(conversation);
        conversations.put(profiles.get("03"), conversationsList03);

        //create server
        Server server = new Server(conversations, profiles);

        App app = new App(server);
        app.run();

    }
}
