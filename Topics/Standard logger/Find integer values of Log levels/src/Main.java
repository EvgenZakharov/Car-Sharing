import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        String[] logLevel = input.split(" ");

        HashMap<String, Integer> logLevelTable = new HashMap<>();
        logLevelTable.put("SEVERE", 1000);
        logLevelTable.put("WARNING", 900);
        logLevelTable.put("INFO", 800);
        logLevelTable.put("CONFIG", 700);
        logLevelTable.put("FINE", 500);
        logLevelTable.put("FINER", 400);
        logLevelTable.put("FINEST", 300);

        int sum = 0;

        for (String el : logLevel) {
            sum += logLevelTable.get(el);
        }

        System.out.println(sum);
    }
}