import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

class Main {

    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        // write your code here
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return LongStream.range(1, n + 1).reduce((x, y ) -> (x * y)).orElse(0);
        }


    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(factorial(n));
    }
}