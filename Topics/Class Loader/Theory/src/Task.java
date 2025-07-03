// You can experiment here, it won’t be checked

import java.util.Scanner;

//public class Task {
//  public static void main(String[] args) {
//    ClassLoader classLoader = Scanner.class.getClassLoader();
//    System.out.println(classLoader);
//  }
//}

public class Task {
  public static void main(String[] args) {
    ClassLoader classLoader = A.class.getClassLoader();
    System.out.println(classLoader.getName());
  }
}

class A {
}