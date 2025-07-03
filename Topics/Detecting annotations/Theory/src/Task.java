// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    demo(input);
  }

  public static void demo(String input) {
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      System.out.println(element);
    }

    int number = Integer.parseInt(input); // an exception is possible here!
    System.out.println(number + 1);
  }
}