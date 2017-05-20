package geeks4geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KatKat on 19/05/17.
 */
//http://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring
public class LongestKUniqueSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int num = 0; num < count; ++num) {
            String line = scanner.next();
            int k = scanner.nextInt();

            int i = 0;
            int j = 0;
            Map<Character, Integer> positions = new HashMap<>();

            while (j < line.length() && positions.size() != k) {
                char ch = line.charAt(j);
                positions.put(ch, j);
                ++j;
            }

            int max = -1;
            while (j < line.length()) {
                char next = line.charAt(j);
                if (!positions.containsKey(next)) {
                    Character ch = line.charAt(i);
                    while (positions.get(ch) != i) {
                        ++i;
                        ch = line.charAt(i);
                    }
                    positions.remove(ch);
                    ++i;
                }
                positions.put(next, j);
                ++j;
                max = Math.max(j - i, max);
            }
            System.out.println(max);
        }
    }
}

