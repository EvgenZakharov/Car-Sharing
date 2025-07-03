import java.util.Comparator;

public class MessageContentComparator  implements Comparator<Message> {

    @Override
    public int compare(Message message1, Message message2) {
        // here we should define how these two arguments will be compared
        int firstLength = message1.getContent().length();
        int secondLength = message2.getContent().length();
        return Integer.compare(firstLength, secondLength);
    }
}
