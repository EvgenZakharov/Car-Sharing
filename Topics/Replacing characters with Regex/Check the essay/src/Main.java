import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class CheckTheEssay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        // Define replacement rules using regex patterns and their replacements
        String[][] replacements = {
                {"Franse", "France"},
                {"Eifel tower", "Eiffel Tower"},
                {"19th", "XIXth"},
                {"20th", "XXth"},
                {"21st", "XXIst"}
        };

        // Apply each regex replacement
        for (String[] replacement : replacements) {
            String regex = replacement[0];
            String replacementText = replacement[1];

            // Use Pattern and Matcher to find and replace
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            text = matcher.replaceAll(replacementText); // Replace all matches
        }

        // Output the modified text
        System.out.println(text);

    }
}