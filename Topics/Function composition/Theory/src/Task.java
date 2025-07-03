// You can experiment here, it won’t be checked

import java.util.function.Consumer;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Consumer<Integer> printer = System.out::println;
    Consumer<Integer> devNull = (val) -> { int v = val * 2; };

    Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
    combinedConsumer.accept(100);

  }
}
