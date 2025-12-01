import java.util.*;

/* reverse-a-string
Ask the user to enter a string and display its reverse
without using built-in reverse functions.
 */

public class Item9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char[] arr = s.toCharArray();
        System.out.print("Reversed: ");
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i]);
    }
}
