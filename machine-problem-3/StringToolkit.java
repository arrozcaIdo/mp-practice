import java.util.*;

// abstract base
abstract class mToolkit {
    protected String input;

    public mToolkit(String input) {
        this.input = input;
    }

    public abstract void process();
}

record Toolkit(String input) { // record for efficiency

    public String reverse() {
        return new StringBuilder(input).reverse().toString();
    }

    // a man. a plan. a canal: panama!
    public boolean isPalindrome() {
        String norm = input.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
        return norm.equals(new StringBuilder(norm).reverse().toString());
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
        Toolkit toolkit = new Toolkit(input);
        System.out.println("Reversed: " + toolkit.reverse());
    }
}

// 2. Palindrome
class PalindromeTool extends mToolkit {
    public PalindromeTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        boolean isPal = toolkit.isPalindrome();
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
        Toolkit toolkit = new Toolkit(input);
        System.out.println("Word count: " + toolkit.wordCount());
    }
}

// 5. Character Count
class CharCountTool extends mToolkit {
    public CharCountTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        System.out.println("Character count (spaces omitted): " + toolkit.charCount());
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
        Toolkit toolkit = new Toolkit(input);
        List<Integer> positions = toolkit.findSubstring(sub);
        System.out.println(positions.isEmpty() ? "Substring not found." : "Found at: " + positions);
    }
}

// 7. Lowercase
class LowerTool extends mToolkit {
    public LowerTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        System.out.println(toolkit.toLower());
    }
}

// 8. Uppercase
class UpperTool extends mToolkit {
    public UpperTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        System.out.println(toolkit.toUpper());
    }
}

// 9. Vowel Remover
class VowelTool extends mToolkit {
    public VowelTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        System.out.println(toolkit.removeVowels());
    }
}

// 10. Consonant Remover
class ConsonantTool extends mToolkit {
    public ConsonantTool(String input) { super(input); }
    public void process() {
        Toolkit toolkit = new Toolkit(input);
        System.out.println(toolkit.removeConsonants());
    }
}


// main
public class StringToolkit {
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

        // error handler
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

        tool.process();

        sc.close();
    }
}
