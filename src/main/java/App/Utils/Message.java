package App.Utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    Profile sender;
    Timestamp timestamp;
    String type;
    String content;

    public Message(Profile sender, Timestamp timestamp, String type, String content) {
        this.sender = sender;
        this.timestamp = timestamp;
        this.type = type;
        this.content = content;
    }

    @Override
    public String toString() {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String readableDate = localDateTime.format(formatter);

        return sender.getName()+" - "+readableDate+"\n"+content+"\n";
    }
}
