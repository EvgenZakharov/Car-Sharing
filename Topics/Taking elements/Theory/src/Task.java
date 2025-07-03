// You can experiment here, it won’t be checked

import java.util.List;
import java.util.stream.Collectors;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> fibonacci = List.of(0, 1, 1, 2, 3, 5, 8, 13);

    List<Integer> result = fibonacci.stream()
            .dropWhile(n -> n > 5)
            .collect(Collectors.toList());

  }
}
