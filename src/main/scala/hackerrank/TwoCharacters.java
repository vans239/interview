package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/two-characters
public class TwoCharacters {
    static int maxSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        for(int i = 0; i < s.length(); ++i) {
            unique.add(s.charAt(i));
        }

        int totalMax = -1;
        for(Character c : unique) {
            for (Character e: unique) {
                if (c != e) {
                    int total = 0;
                    Character previous = null;
                    for(int i = 0; i < s.length(); ++i) {
                        Character q = s.charAt(i);
                        if (q == c || q == e) {
                            if (previous == q) {
                                total = Integer.MIN_VALUE;
                            }
                            ++total;
                            previous = q;

                        }
                    }
                    totalMax = Math.max(total, totalMax);
                }
            }
        }
        return Math.max(totalMax, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();

        System.out.println(maxSubstring(s));
    }
}
