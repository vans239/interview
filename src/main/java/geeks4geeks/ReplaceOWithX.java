package geeks4geeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by KatKat on 19/05/17.
 */
//http://practice.geeksforgeeks.org/problems/replace-os-with-xs
public class ReplaceOWithX {
    static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "row " + row + " column " + column;
        }
    }

    public static void tryQueue(Queue<Point> queue, int row, int column, boolean[][] used, boolean[][] array) {
        if (row >= 0 && row < used.length && column >= 0 && column < used[0].length
                && !used[row][column] && array[row][column]) {
            used[row][column] = true;
            queue.add(new Point(row, column));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; ++i) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            boolean[][] array = new boolean[rows][];
            for (int j = 0; j < rows; ++j)
                array[j] = new boolean[columns];

            for (int j = 0; j < rows; ++j) {
                for (int k = 0; k < columns; ++k) {
                    String s = scanner.next();
                    array[j][k] = !s.equals("X");
                }
            }

            //bfs
            boolean[][] used = new boolean[rows][];
            for (int j = 0; j < rows; ++j)
                used[j] = new boolean[columns];

            Queue<Point> queue = new LinkedList<Point>();
            for (int j = 0; j < rows; ++j) {
                for (int k = 0; k < columns; ++k) {
                    if ((j == 0 || j == rows - 1 || k == 0 || k == columns - 1) && array[j][k]) {
                        queue.add(new Point(j, k));
                        used[j][k] = true;
                    }
                }
            }


            while (!queue.isEmpty()) {
                ReplaceOWithX.Point p = queue.poll();
                tryQueue(queue, p.row - 1, p.column, used, array);
                tryQueue(queue, p.row, p.column - 1, used, array);
                tryQueue(queue, p.row + 1, p.column, used, array);
                tryQueue(queue, p.row, p.column + 1, used, array);

            }

            for (int j = 0; j < rows; ++j) {
                for (int k = 0; k < columns; ++k) {
                    if (used[j][k])
                        System.out.print("O ");
                    else
                        System.out.print("X ");
                }
            }
            System.out.println();
        }

    }
}

/*
2
1 5
X O X O X
3 3
X X X X O X X X X

1
3 3
X X X X O X X X X
 */