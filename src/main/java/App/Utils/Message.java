package App.Utils;

import java.sql.Timestamp;

public class Message {
    Profile sender;
    Timestamp timestamp;
    String type;
    String content;

    Message(Profile sender, Timestamp timestamp, String type, String content) {
        this.sender = sender;
        this.timestamp = timestamp;
        this.type = type;
        this.content = content;
    }
}
