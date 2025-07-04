// You can experiment here, it won’t be checked
import java.util.*;
import java.util.stream.*;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

    List<Integer> generated = numbers.stream()
            .flatMap(n -> Stream.generate(() -> n).limit(n))
            .collect(Collectors.toList());

    List<Integer> generated2 = numbers.stream()
            .flatMapToInt(n -> IntStream.rangeClosed(1, n))
            .boxed()
            .collect(Collectors.toList());

    List<Integer> generated3 = numbers.stream()
            .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
            .boxed()
            .collect(Collectors.toList());

    List<Integer> generated4 = numbers.stream()
            .flatMap(Stream::of)
            .collect(Collectors.toList());


  }
}
