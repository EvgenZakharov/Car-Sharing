import java.util.Locale;

class StringUtils {
    public static boolean isPalindrome(String str) {
        // your code here
        if (str == null || str.isEmpty()) {
            return false; // Empty strings or null are not palindromes
        }

        // Normalize the string: remove non-alphanumeric characters and convert to lowercase
//        String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        String normalized = str.replaceAll("[ ,'!]", "").toLowerCase();

        // Use two pointers to check if the string is a palindrome
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }

        return true; // If all characters match, it's a palindrome
    }
}