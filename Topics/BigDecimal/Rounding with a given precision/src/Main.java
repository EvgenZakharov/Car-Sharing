import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String firstStr = scanner.nextLine();
        int secondInt = scanner.nextInt();

        BigDecimal bigDecimal = new BigDecimal(firstStr).setScale(secondInt, RoundingMode.HALF_DOWN);
        System.out.println(bigDecimal);

    }   
}