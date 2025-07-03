import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read input as BigInteger
        BigInteger M = scanner.nextBigInteger();

        // Initialize variables
        BigInteger factorial = BigInteger.ONE;
        long n = 1;

        // Calculate n! iteratively until n! >= M
        while (factorial.compareTo(M) < 0) {
            n++;
            factorial = factorial.multiply(BigInteger.valueOf(n));
        }

        // Output the result
        System.out.println(n);
    }
}