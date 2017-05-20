package geeks4geeks;

import java.util.*;
import java.lang.*;

//http://practice.geeksforgeeks.org/problems/meta-strings
class MetaStrings {

    static boolean isMeta(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int i = 0;
        int diff = 0;
        while(i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                ++diff;
            }
            ++i;
        }
        return diff == 2;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        while(tests > 0) {
            String a = scanner.next();
            String b = scanner.next();
            if (isMeta(a, b)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
            --tests;
        }

    }
}