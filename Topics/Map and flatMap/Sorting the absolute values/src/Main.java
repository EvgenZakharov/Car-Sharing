import java.util.*;
import java.util.stream.Collectors;


public class Main {

    /**
     * Returns the sorted array of absolute numbers in ascending order.
     *
     * @param numbers the input array of String integer numbers
     * @return the sorted array of integer absolute numbers
     */
    public static int[] sortedAbsNumbers(String[] numbers) {
        // write your code here
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt) // Convert each string to an integer
                .map(Math::abs)             // Get the absolute value of each integer
                .sorted()                   // Sort the integers in ascending order
                .toArray();


    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(sortedAbsNumbers(scanner.nextLine().split("\\s+")))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}