package geeks4geeks;

import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/generate-binary-string/0
public class BinaryStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest) {
            String s = scanner.next();

            int unknown = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '?') {
                    ++unknown;
                }
            }

            int totalSolutions = 1 << unknown;
            for (int mask = 0; mask < totalSolutions; ++mask) {
                int curr = 0;
                for (int i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) != '?') {
                        System.out.print(s.charAt(i));
                    } else {
                        ++curr;
                        int value = mask & (1 << (unknown - curr));
                        if (value != 0) {
                            System.out.print(1);
                        } else {
                            System.out.print(0);
                        }
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

