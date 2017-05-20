package geeks4geeks;

import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/finding-the-numbers
public class FindingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest ) {
            int n = scanner.nextInt();
            int size = n * 2 + 2;
            int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = scanner.nextInt();
            }

            int xor = 0;
            for (int i : array) {
                xor = xor ^ i;
            }
            //choose any bit from xor
            int filterBit = 1;
            while ((filterBit & xor) == 0) {
                filterBit = filterBit << 1;
            }

            int partialxor = 0;
            for (int i : array) {
                if ((filterBit & i) != 0) {
                    partialxor = partialxor ^ i;
                }
            }

            int a = partialxor;
            int b = xor ^ partialxor;

            if ( a < b) {
                System.out.println(a + " " + b);
            } else {
                System.out.println(b + " " + a);
            }
        }
    }
}
