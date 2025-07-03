import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        BigDecimal first = new BigDecimal(scanner.nextLine());
        BigDecimal second = new BigDecimal(scanner.nextLine());
        BigDecimal third = new BigDecimal(scanner.nextLine());

        BigDecimal sum = first.add(second).add(third);
        BigDecimal average = sum.divide(new BigDecimal(3), 0, RoundingMode.DOWN);

        System.out.println(average);

        scanner.close();

    }
}