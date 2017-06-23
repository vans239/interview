package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/candies
public class Candies {

    public static int neededCandiesValue(int[] array, int[] candies, int i, int neighbor) {
        if (neighbor >= 0 && neighbor < array.length && array[i] > array[neighbor]) {
            return candies[neighbor] + 1;
        } else {
            return 0;
        }
    }

    public static long countCandies(int[] ratings) {
        int[] candies = new int[ratings.length];
        Integer[] indexes = new Integer[ratings.length];
        for(int i = 0; i < indexes.length; ++i) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(ratings[a], ratings[b]);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for(Integer index : indexes) {
            int neededCandies = 1;
            neededCandies = Math.max(neededCandies, neededCandiesValue(ratings, candies, index, index - 1));
            neededCandies = Math.max(neededCandies, neededCandiesValue(ratings, candies, index, index + 1));
            candies[index] = neededCandies;
        }

        long total = 0;
        for (int candy: candies) {
            total += candy;
        }
        return total;
    }

    public static void main(String args[] ) throws Exception {
//        int[] ratings = {1, 1, 1};
//        int[] ratings = {2,4,2,6,1,7,8,9,2,1};
//        int[] ratings = {};
//        int[] ratings = {5};
//        int[] ratings = {1, 2, 3, 4, 5, 6};
//        System.out.println(countCandies(ratings));
//        System.exit(0);

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < array.length; ++i) {
            array[i] = scanner.nextInt();
        }

        System.out.println(countCandies(array));
    }

}
