import java.util.*;

/* frequency-of-elements-in-an-array
Write a program that accepts n numbers into an array and counts how many times each number
appears. Display the frequency of each element.
 */

public class Item15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int x : arr)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        System.out.println("Frequencies:");
        for (var e : freq.entrySet())
            System.out.println(e.getKey() + " = " + e.getValue());
    }
}
