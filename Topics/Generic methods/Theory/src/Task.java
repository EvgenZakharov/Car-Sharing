// You can experiment here, it won’t be checked
import java.util.*;
import java.util.stream.Collectors;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> numbers = Arrays.asList(5, 3, 4, 1);

    Set<Triple<Integer, Integer, String>> set = numbers.stream()
            .map(val -> new Triple<>(val, val * val, String.valueOf(val) + String.valueOf(val)))
            .collect(Collectors.toSet());

  }
}

final class Triple<L, M, R> {
  private final L left;
  private final M middle;
  private final R right;

  Triple(L left, M middle, R right) {
    this.left = left;
    this.middle = middle;
    this.right = right;
  }
}
