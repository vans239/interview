package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;

/**
 * Created by vans239 on 30/05/17.
 */
public class CountingGroups {

    static class Point {
        Integer i;
        Integer j;

        Point(Integer i, Integer j) {
            this.i = i;
            this.j = j;
        }

        boolean isInside(int[][] m) {
            return i >= 0 && i < m.length && j >= 0 && j < m[0].length;
        }

        @Override
        public String toString() {
            return "i = " + i + " j = " + j;
        }
    }

    static void addIfNeeded(Point curr, int[][] m, Queue<Point> queue, boolean[][] used) {
        if (curr.isInside(m) && m[curr.i][curr.j] == 1 && !used[curr.i][curr.j]) {
            used[curr.i][curr.j] = true;
            queue.add(curr);
        }
    }

    static int[] countGroups(int[][] m, int[] t) {
        boolean used[][] = new boolean[m.length][];
        for(int i = 0; i < used.length; ++i) {
            used[i] = new boolean[m[0].length];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                if (!used[i][j]) {
                    int currCount = 0;
                    Point startPoint = new Point(i, j);
                    Queue<Point> queue = new LinkedList<>();
                    addIfNeeded(startPoint, m, queue, used);
                    while (!queue.isEmpty()) {
                        Point curr = queue.poll();
                        ++currCount;
                        addIfNeeded(new Point(curr.i - 1, curr.j), m, queue, used);
                        addIfNeeded(new Point(curr.i + 1, curr.j), m, queue, used);
                        addIfNeeded(new Point(curr.i, curr.j - 1), m, queue, used);
                        addIfNeeded(new Point(curr.i, curr.j + 1), m, queue, used);
                    }
                    if (currCount != 0) {
                        map.put(currCount, map.getOrDefault(currCount, 0) + 1);
                    }
                }
            }
        }

        int[] results = new int[t.length];
        for(int i = 0; i < results.length; ++i) {
            results[i] = map.getOrDefault(t[i], 0);
        }
        return results;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new FileInputStream("input.txt"));
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        int[] res;

        int _m_rows = 0;
        int _m_cols = 0;
        _m_rows = Integer.parseInt(in.nextLine().trim());
        _m_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _m = new int[_m_rows][_m_cols];
        for(int _m_i=0; _m_i<_m_rows; _m_i++) {
            for(int _m_j=0; _m_j<_m_cols; _m_j++) {
                _m[_m_i][_m_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        int _t_size = 0;
        _t_size = Integer.parseInt(in.nextLine().trim());
        int[] _t = new int[_t_size];
        int _t_item;
        for(int _t_i = 0; _t_i < _t_size; _t_i++) {
            _t_item = Integer.parseInt(in.nextLine().trim());
            _t[_t_i] = _t_item;
        }

        res = countGroups(_m, _t);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
