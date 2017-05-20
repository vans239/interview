package geeks4geeks;

import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/max-absolute-difference
public class MaxAbsoluteDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; ++i) {
                arr[i] = scanner.nextInt();
            }

            int[] sums = new int[size + 1];
            sums[0] = 0;
            for(int i = 1; i < sums.length; ++i) {
                sums[i] = sums[i - 1] + arr[i - 1];
            }

            int max = -1;
            for (int i = 0; i < sums.length; ++i) {
                for (int j = i; j < sums.length; ++j) {
                    for (int k = j; k < sums.length; ++k) {
                        int left = sums[j] - sums[i];
                        int right = sums[k] - sums[j];
                        if (Math.abs(left - right) > max)
                            max = Math.max(max, Math.abs(left - right));
                    }
                }
            }
            System.out.println(max);
        }
    }
}
