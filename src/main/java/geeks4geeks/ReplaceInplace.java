package geeks4geeks;

import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/remove-b-and-ac-from-a-given-string
public class ReplaceInplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int currTest = 0; currTest < tests; ++currTest) {
            String line = scanner.next();

            boolean stateA = false;
            for (int i = 0; i < line.length(); ++i) {
                char ch = line.charAt(i);
                if (stateA) {
                    if (ch == 'b') {
                        System.out.print('a');
                        stateA = false;
                    } else if (ch == 'a') {
                        System.out.print('a');
                    } else if (ch == 'c') {
                        stateA = false;
                    } else {
                        System.out.print('a');
                        System.out.print(ch);
                        stateA = false;
                    }
                } else {
                    if (ch == 'a') {
                        stateA = true;
                    } else if (ch != 'b') {
                        System.out.print(ch);
                    }
                }
            }
            if (stateA) System.out.print('a');
            System.out.println();
        }
    }
}
