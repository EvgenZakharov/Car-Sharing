import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("\\b\\d{10,}\\b");
        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            String bigNumber = matcher.group();
            System.out.println(bigNumber + ":" + bigNumber.length());
        }

        scanner.close();

    }
}