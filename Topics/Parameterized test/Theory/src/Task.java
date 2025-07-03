// You can experiment here, it won’t be checked
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task {
  public static void main(String[] args) {
    // put your code here
    ExecutorService executor = Executors.newFixedThreadPool(4);

    for (int i = 1; i <= 2; i++) {
      int taskNumber = i;
      executor.submit(() -> System.out.println("Starting task-" + taskNumber));
    }

      try {
          TimeUnit.MILLISECONDS.sleep(50); // the current thread waits for 50 millis
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }

      executor.shutdown();

    System.out.println("Main completed");
  }
}



