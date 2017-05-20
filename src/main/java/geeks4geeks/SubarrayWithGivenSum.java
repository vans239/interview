package geeks4geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KatKat on 21/05/17.
 */
//http://practice.geeksforgeeks.org/problems/subarray-with-given-sum
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest) {
            int n = scanner.nextInt();
            int expected = scanner.nextInt();

            Map<Integer, Integer> partialSums = new HashMap<>();
            partialSums.put(0, 0);

            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = scanner.nextInt();
            }

            int current = 0;
            boolean found = false;
            for (int i = 1; i <= n && !found; ++i) {
                int el = array[i - 1];
                current += el;
                int needed = current - expected;
                if (partialSums.containsKey(needed)) {
                    found = true;
                    int start = partialSums.get(needed) + 1;
                    System.out.println(start + " " + i);
                }
                partialSums.put(current, i);
            }
            if (!found) System.out.println("-1");

        }
    }
}
