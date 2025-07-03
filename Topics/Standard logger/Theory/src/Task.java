// You can experiment here, it won’t be checked

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
  private final static int POOL_SIZE = 4;
  private final static int NUMBER_OF_TASKS = 10;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    for (int i = 0; i < NUMBER_OF_TASKS; i++) {
      int taskNumber = i;
      executor.submit(() -> {
        String taskName = "task-" + taskNumber;
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s executes %s\n", threadName, taskName);
      });
    }

    executor.shutdown();
  }
}