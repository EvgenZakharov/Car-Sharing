import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String startingAmountString = scanner.nextLine();
        String yearlyPercentString = scanner.nextLine();
        String yearsString = scanner.nextLine();

        BigDecimal startingAmount = new BigDecimal(startingAmountString);
        BigDecimal yearlyPercent = new BigDecimal(yearlyPercentString);
        int years = Integer.valueOf(yearsString);

        BigDecimal finalAmount = startingAmount.multiply(BigDecimal.ONE.add(yearlyPercent.divide(BigDecimal.valueOf(100))).pow(years)).setScale(2, RoundingMode.CEILING);

        System.out.println("Amount of money in the account: " + finalAmount);

    }
}