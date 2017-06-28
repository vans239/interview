package hackerrank;

import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/encryption
public class Encryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();

        int row = 0;
        int column = 0;

        while(row * column < len) {
            if (row == column) {
                ++column;
            } else {
                ++row;
            }
        }

        for (int start = 0; start < column; ++start) {
            int i = start;
            StringBuilder sb = new StringBuilder();
            while(i < s.length()) {
                sb.append(s.charAt(i));
                i += column;
            }
            if (start + 1 != column) {
                sb.append(' ');
            }
            System.out.print(sb.toString());
        }
    }
}