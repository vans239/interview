package geeks4geeks;

import java.util.*;
import java.lang.*;

//http://practice.geeksforgeeks.org/problems/find-median-in-a-stream
class MedianInStream {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for(int i = 0; i < n; ++i) {
            left.add(scanner.nextInt());

            //balance size
            while(left.size() > right.size() + 1) {
                right.add(left.poll());
            }

            //balance values
            while(right.size() > 0 && left.peek() > right.peek()) {
                int tmp = left.poll();
                left.add(right.poll());
                right.add(tmp);
            }

            if (left.size() == right.size() + 1) {
                System.out.println(left.peek());
            } else {
                System.out.println((left.peek() + right.peek()) / 2);
            }
        }
    }
}