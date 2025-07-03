import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        // write your code here
//        return List.of();
        return codes.stream()
                .dropWhile(code -> !code.equals("#0000")) // Skip all elements before "#0000"
                .skip(1) // Skip "#0000" itself
                .takeWhile(code -> !code.equals("#FFFF")) // Take elements until "#FFFF"
                .collect(Collectors.toList()); // Collect the result into a list
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}