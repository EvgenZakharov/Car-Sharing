// You can experiment here, it won’t be checked
import java.util.*;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here

    List<Message> messages = new ArrayList<>();

    messages.add(new Message("Hello", "2034-03-25"));
    messages.add(new Message("humans!", "2032-01-05"));
    messages.add(new Message("We", "2031-02-17"));
    messages.add(new Message("came", "2055-01-14"));
    messages.add(new Message("in", "2026-01-14"));
    messages.add(new Message("peace!", "2012-01-14"));

//    messages.sort(new MessageContentComparator());
//    messages.sort(dateComparator);

//    Comparator<Message> dateComparator = (m1, m2) ->
//            m1.getCreated().compareTo(m2.getCreated());
//
//    messages.sort(dateComparator);

    messages.sort((m1, m2) -> m1.getCreated().compareTo(m2.getCreated()));

    messages.forEach(System.out::println);

  }
}
