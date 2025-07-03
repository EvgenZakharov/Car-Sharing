import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    /**
     * Returns the average value of numbers from a Set
     * that is accumulated from the input stream.
     *
     * @param numbers the input stream of Integer elements
     * @return average value of a Set of numbers
     */
    public static Double avgOnSet(Stream<Integer> numbers) {
        // write your code here

        // Accumulate the numbers into a Set to ensure uniqueness, then calculate the average:
        return numbers.collect(Collectors.toSet()) // Collect into a Set to remove duplicates
                .stream()                          // Convert the Set back to a Stream
                .collect(Collectors.averagingDouble(Integer::doubleValue)); // Calculate the average
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stream<Integer> integerStream = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt);
        System.out.println(avgOnSet(integerStream));
    }
}