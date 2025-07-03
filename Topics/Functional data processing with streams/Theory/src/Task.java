// You can experiment here, it won’t be checked

import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here

    Stream<String> persons = Stream.of("John", "Demetra", "Cleopatra");

    persons.sorted().forEach(System.out::println);
  }
}
