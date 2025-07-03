// You can experiment here, it won’t be checked
public class Task {
  private final String name;
  private final Task bestFriend;

  public Task(String name) {
    this.name = name;
    this.bestFriend = new Task(name + "'s friend");
  }

  public String getName() {
    return name;
  }

  public Task getBestFriend() {
    return bestFriend;
  }

  public static void main(String[] args) {
    Task person = new Task("Kate"); // line 1
    System.out.println(person.getBestFriend().getName()); // line 2
  }
}