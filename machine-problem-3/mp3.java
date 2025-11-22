import java.util.*;

// abstract base
abstract class mToolkit {
    protected String input;

    public mToolkit(String input) {
        this.input = input;
    }

    public abstract void process();
}

record Toolkit(String input) {

    public String reverse() {

        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome() {
        String norm = input.replaceAll("\\s+", "").toLowerCase(); // cleaning/normalizing input
        return norm.equals(new StringBuilder(norm).reverse().toString()); //sbuilder for
    }

    public static boolean isAnagram(String a, String b) {
        char[] arr1 = a.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] arr2 = b.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public int wordCount() {
        return input.trim().split("\\s+").length;
    }

    public int charCount() {
        return input.replace(" ", "").length();
    }

    public List<Integer> findSubstring(String sub) {
        List<Integer> pos = new ArrayList<>();
        int index = input.indexOf(sub);
        while (index != -1) {
            pos.add(index);
            index = input.indexOf(sub, index + 1);
        }
        return pos;
    }

    public String toLower() {
        return input.toLowerCase();
    }

    public String toUpper() {
        return input.toUpperCase();
    }

    public String removeVowels() {
        return input.replaceAll("(?i)[aeiou]", "");
    }

    public String removeConsonants() {
        return input.replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]", "");
    }
}

// 1. Reverse
class ReverseTool extends mToolkit {
    public ReverseTool(String input) { super(input); }
    public void process() {
        System.out.println("Reversed: " + new StringBuilder(input).reverse());
    }
}

// 2. Palindrome
class PalindromeTool extends mToolkit {
    public PalindromeTool(String input) { super(input); }
    public void process() {
        String norm = input.replaceAll("\\s+", "").toLowerCase();
        boolean isPal = norm.contentEquals(new StringBuilder(norm).reverse());
        System.out.println(isPal ? "Palindrome" : "Not a palindrome");
    }
}

// 3. Anagram
class AnagramTool extends mToolkit {
    private final String second;
    public AnagramTool(String input, String second) {
        super(input);
        this.second = second;
    }
    public void process() {
        boolean result = Toolkit.isAnagram(input, second);
        System.out.println(result ? "Anagram" : "Not an anagram");
    }
}

// 4. Word Count
class WordCountTool extends mToolkit {
    public WordCountTool(String input) { super(input); }
    public void process() {
        System.out.println("Word count: " + input.trim().split("\\s+").length);
    }
}

// 5. Character Count
class CharCountTool extends mToolkit {
    public CharCountTool(String input) { super(input); }
    public void process() {
        System.out.println("Character count (spaces omitted): " + input.replace(" ", "").length());
    }
}

// 6. Substring Finder
class SubstringTool extends mToolkit {
    private final String sub;
    public SubstringTool(String input, String sub) {
        super(input);
        this.sub = sub;
    }
    public void process() {
        List<Integer> pos = new ArrayList<>();
        int i = input.indexOf(sub);
        while (i != -1) {
            pos.add(i);
            i = input.indexOf(sub, i + 1);
        }
        System.out.println(pos.isEmpty() ? "Substring not found." : "Found at: " + pos);
    }
}

// 7. Lowercase
class LowerTool extends mToolkit {
    public LowerTool(String input) { super(input); }
    public void process() {
        System.out.println(input.toLowerCase());
    }
}

// 8. Uppercase
class UpperTool extends mToolkit {
    public UpperTool(String input) { super(input); }
    public void process() {
        System.out.println(input.toUpperCase());
    }
}

// 9. Vowel Remover
class VowelTool extends mToolkit {
    public VowelTool(String input) { super(input); }
    public void process() {
        System.out.println(input.replaceAll("(?i)[aeiou]", ""));
    }
}

// 10. Consonant Remover
class ConsonantTool extends mToolkit {
    public ConsonantTool(String input) { super(input); }
    public void process() {
        System.out.println(input.replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]", ""));
    }
}

// main
public class mp3 {

    public static int countSentences(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '.' || c == '?' || c == '!') count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----STRING MANIPULATION TOOLKIT----");
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

        int choice;

        // Validate user choice
        while (true) {
            System.out.print("\nEnter your choice (1–10): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= 10) break;
            }
            System.out.print("Error: Enter a number between (1) and (10).");
            sc.nextLine();
        }

        String input;
        while (true) {
            System.out.print("\nEnter text (must contain exactly 3 sentences):");
            input = sc.nextLine();
            if (countSentences(input) == 3) break;
            System.out.println("Error: Enter EXACTLY 3 sentences.");
        }

        mToolkit tool; //

        switch (choice) {
            case 1: tool = new ReverseTool(input); break;
            case 2: tool = new PalindromeTool(input); break;
            case 3:
                System.out.print("Enter second string: ");
                String second = sc.nextLine();
                tool = new AnagramTool(input, second);
                break;
            case 4: tool = new WordCountTool(input); break;
            case 5: tool = new CharCountTool(input); break;
            case 6:
                System.out.print("Enter substring: ");
                String sub = sc.nextLine();
                tool = new SubstringTool(input, sub);
                break;
            case 7: tool = new LowerTool(input); break;
            case 8: tool = new UpperTool(input); break;
            case 9: tool = new VowelTool(input); break;
            case 10: tool = new ConsonantTool(input); break;
            default: return;
        }

        tool.process(); //

        sc.close();
    }
}
