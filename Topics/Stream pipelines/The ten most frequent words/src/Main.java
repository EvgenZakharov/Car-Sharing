import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        // Read input text from standard input (UTF-8)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String text = reader.lines().collect(Collectors.joining(" "));

        // Process the text to find the 10 most frequent words
        List<String> topWords = Arrays.stream(text.toLowerCase().split("\\W+")) // Split into words, case-insensitive
                .filter(word -> !word.isEmpty()) // Remove empty strings
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Count word frequencies
                .entrySet().stream() // Convert to a stream of Map entries
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed() // Sort by frequency (descending)
                        .thenComparing(Map.Entry::getKey)) // Then sort lexicographically
                .limit(10) // Take the top 10 entries
                .map(Map.Entry::getKey) // Extract the words
                .collect(Collectors.toList()); // Collect as a list

        // Print the top 10 words
        topWords.forEach(System.out::println);

    }
}