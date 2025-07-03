import java.time.LocalDate;

public class Message {

    private final String content;
    private final LocalDate created;

    public Message(String content, String created) {
        this.content = content;
        this.created = LocalDate.parse(created);
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return created.toString() + " " + " wrote: " +
                content + " (" + ")";
    }

}
