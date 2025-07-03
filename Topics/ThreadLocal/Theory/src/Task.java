// You can experiment here, it won’t be checked

public class Task {
  private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

  public static void main(String[] args) throws InterruptedException {
    class MyRunnable implements Runnable {

      @Override
      public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " BEFORE: " + threadLocal.get());

        threadLocal.set(name + " value");
        System.out.println(name + " AFTER: " + threadLocal.get());
      }
    };

    threadLocal.set("threadLocal main value");

    Thread thread1 = new Thread(new MyRunnable(), "first_thread");
    Thread thread2 = new Thread(new MyRunnable(), "second_thread");

    // first
    thread1.start();
    thread1.join();
    // second
    thread2.start();
    thread2.join();

    System.out.println("From the main thread: " + threadLocal.get());
  }
}
