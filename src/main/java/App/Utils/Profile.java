package App.Utils;

import App.Terminal;

import java.util.ArrayList;

public class Profile {
    String phoneNumber;
    String pseudo;
    String picturePath;
    private ArrayList<Profile> contact;
    String status;

    public Profile(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        if (this.pseudo == null) {
            return phoneNumber;
        }
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
        Terminal.terminalInfo("Profile name successfully changed for "+this.pseudo);
    }

    void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public int hashCode() {
        return this.pseudo.hashCode();
    }
}


