package hackerrank;

import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/non-divisible-subset
public class NonDivisibleSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] counts = new int[k];

        for (int i = 0; i < n; ++i) {
            int value = scanner.nextInt();
            ++counts[value % k];
        }

        int total = 0;

        for (int i = 1; 2 * i < k; ++i) {
            total += Math.max(counts[i], counts[(k - i) % k]);
        }

        if (k % 2 == 0 && counts[k / 2] > 0) {
            total += 1;
        }

        if (counts[0] > 0) {
            total += 1;
        }
        System.out.println(total);

    }
}

/*
4 3
1 7 2 4

3
 */

/*
4 4
1 7 2 4

3
 */

/*
4 4
2 2 2 2

1
 */

/*
4 4
1 1 1 1

1
 */