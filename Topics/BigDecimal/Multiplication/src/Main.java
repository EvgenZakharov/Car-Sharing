import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        BigDecimal first = new BigDecimal(scanner.nextLine());
        BigDecimal second = new BigDecimal(scanner.nextLine());

        BigDecimal mult = first.multiply(second);

        System.out.println(mult);

        scanner.close();

    }
}