// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) throws Exception {
    Class clazz = double[][][][].class;
    String s = "[[[[D";
    Class forName = Class.forName(s);
    System.out.println(clazz.equals(forName));
  }
}