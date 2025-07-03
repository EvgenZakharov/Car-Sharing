import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String DwalinString = scanner.nextLine();
        String BalinString = scanner.nextLine();
        String ThorinString = scanner.nextLine();

        BigDecimal DwalinSum = new BigDecimal(DwalinString);
        BigDecimal BalinSum = new BigDecimal(BalinString);
        BigDecimal ThorinSum = new BigDecimal(ThorinString);

        BigDecimal totalGold = DwalinSum.add(BalinSum).add(ThorinSum);
        System.out.println(totalGold);

    }
}