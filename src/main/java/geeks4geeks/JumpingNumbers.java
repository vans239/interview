package geeks4geeks;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by KatKat on 20/05/17.
 */
//http://practice.geeksforgeeks.org/problems/jumping-numbers
public class JumpingNumbers {
    private static void generate(int max, int j) {
        Queue<Integer> lst = new ArrayDeque<>();
        lst.add(j);
        while (!lst.isEmpty()) {
            int value = lst.poll();
            if (value <= max) {
                System.out.print(value + " ");
                int mod = value % 10;
                if (mod != 0) lst.add(value * 10 + mod - 1);
                if (mod != 9) lst.add(value * 10 + mod + 1);
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int currTests = 0; currTests < tests; ++currTests) {
            int max = scanner.nextInt();
            System.out.print("0 ");
            for (int i = 1; i < 10; ++i) {
                generate(max, i);
            }
            System.out.println();
        }

    }
}
