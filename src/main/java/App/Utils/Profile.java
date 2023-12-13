package App.Utils;

import App.View.Terminal;

import java.util.HashSet;

public class Profile {
    String phoneNumber;
    String pseudo;
    String picturePath;
    HashSet<Profile> contacts = new HashSet<>();

    public Profile(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        if (this.pseudo == null) {
            return phoneNumber;
        }
        return pseudo;
    }

    public HashSet<Profile> getContacts() {
        return contacts;
    }

    public void addContacts(HashSet<Profile> profiles) {
        contacts.addAll(profiles);
    }

    public void removeContacts(HashSet<Profile> profiles) {
        contacts.removeAll(profiles);
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
        Terminal.terminalInfo(getName(),"Profile name successfully changed for "+this.pseudo);
    }

    void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return this.phoneNumber.hashCode();
    }
}


