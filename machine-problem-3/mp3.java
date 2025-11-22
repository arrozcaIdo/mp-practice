import java.util.*;

public class mp3 {

    // 1. Reverse string
    public static String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    // 2. Palindrome checker
    public static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // 3. Anagram checker
    public static boolean isAnagram(String a, String b) {
        char[] arr1 = a.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] arr2 = b.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 4. Word count
    public static int wordCount(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // 5. Char count (no spaces)
    public static int charCount(String text) {
        return text.replace(" ", "").length();
    }

    // 6. Substring finder
    public static List<Integer> findSubstring(String text, String sub) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(sub);

        while (index != -1) {
            positions.add(index);
            index = text.indexOf(sub, index + 1);
        }
        return positions;
    }

    // 7. Lowercase
    public static String toLower(String text) {
        return text.toLowerCase();
    }

    // 8. Uppercase
    public static String toUpper(String text) {
        return text.toUpperCase();
    }

    // 9. Vowel remover
    public static String removeVowels(String text) {
        return text.replaceAll("(?i)[aeiou]", "");
    }

    // 10. Consonant remover
    public static String removeConsonants(String text) {
        return text.replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]", "");
    }

    // ✔ Sentence counter for 3-sentence validation
    public static int countSentences(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== STRING MANIPULATION TOOLKIT ===");
        System.out.println("1. Reverse String");
        System.out.println("2. Palindrome Checker");
        System.out.println("3. Anagram Checker");
        System.out.println("4. Word Count");
        System.out.println("5. Character Count");
        System.out.println("6. Substring Finder");
        System.out.println("7. Convert to Lowercase");
        System.out.println("8. Convert to Uppercase");
        System.out.println("9. Remove Vowels");
        System.out.println("10. Remove Consonants");

        // Input validation for 1-10
        while (true) {
            System.out.print("\nEnter your choice (1-10): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 10) break;
            }
            System.out.println("Invalid input. Please enter a number from 1 to 10 only.");
            sc.nextLine();
        }

        // ✔ Require EXACTLY 3 sentences
        String text;
        while (true) {
            System.out.println("\nEnter your text (must contain exactly 3 sentences):");
            text = sc.nextLine();

            if (countSentences(text) == 3) {
                break;
            } else {
                System.out.println("Invalid input. Please enter exactly 3 sentences.");
            }
        }

        System.out.println("\n=== RESULT ===");

        switch (choice) {
            case 1:
                System.out.println(reverseString(text));
                break;

            case 2:
                System.out.println(isPalindrome(text) ? "Palindrome" : "Not a palindrome");
                break;

            case 3:
                System.out.print("Enter second string to compare: ");
                String second = sc.nextLine();
                System.out.println(isAnagram(text, second) ? "Anagram" : "Not an anagram");
                break;

            case 4:
                System.out.println("Word count: " + wordCount(text));
                break;

            case 5:
                System.out.println("Character count (no spaces): " + charCount(text));
                break;

            case 6:
                System.out.print("Enter substring to search for: ");
                String sub = sc.nextLine();
                List<Integer> positions = findSubstring(text, sub);

                if (positions.isEmpty()) {
                    System.out.println("Substring not found.");
                } else {
                    System.out.println("Found at positions: " + positions);
                }
                break;

            case 7:
                System.out.println(toLower(text));
                break;

            case 8:
                System.out.println(toUpper(text));
                break;

            case 9:
                System.out.println(removeVowels(text));
                break;

            case 10:
                System.out.println(removeConsonants(text));
                break;
        }

        sc.close();
    }
}
