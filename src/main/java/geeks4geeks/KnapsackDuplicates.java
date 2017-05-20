package geeks4geeks;

import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items
public class KnapsackDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest) {
            int num = scanner.nextInt();
            int maxWeight = scanner.nextInt();

            int[] values = new int[num];
            for (int i = 0; i < num; ++i) {
                values[i] = scanner.nextInt();
            }

            int[] weights = new int[num];
            for (int i = 0; i < num; ++i) {
                weights[i] = scanner.nextInt();
            }

            int[] best = new int[maxWeight + 1];
            best[0] = 0;

            for (int i = 1; i <= maxWeight; ++i) {
                best[i] = best[i - 1];

                for (int j = 0; j < weights.length; ++j) {
                    if (weights[j] <= i) {
                        best[i] = Math.max(best[i], best[i - weights[j]] + values[j]);
                    }
                }
            }

            System.out.println(best[maxWeight]);
        }
    }
}
