package geeks4geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
public class TripletsZeroSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int currTests = 0; currTests < tests; ++currTests) {
            int size = scanner.nextInt();

            int[] arr = new int[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = scanner.nextInt();
            }

            Map<Integer, Integer> values = new HashMap<>();
            for (int i = 0; i < arr.length; ++i) {
                values.put(arr[i], values.getOrDefault(i, 0) + 1);
            }

            boolean found = false;
            for (int i = 0; i < arr.length; ++i) {
                for (int j = i + 1; j < arr.length; ++j) {
                    //bug we can use same value twice
                    int needed = -(arr[i] + arr[j]);
                    int has = values.getOrDefault(needed, 0);
                    if ( has > 1 || (has == 1 && needed != arr[i] && needed != arr[j]) ) {
                        found = true;
                    }
                }
            }
            if (found) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
