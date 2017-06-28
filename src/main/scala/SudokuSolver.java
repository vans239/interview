import java.util.HashSet;
import java.util.Set;

/**
 * Created by vans239 on 29/06/17.
 */
public class SudokuSolver {
    static class Sudoku {
        int[][] matrix;

        public Sudoku(int[][] matrix) {
            this.matrix = matrix;
        }

        void print() {
            for (int i = 0; i < height(); ++i) {
                for (int j = 0; j < width(); ++j) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        boolean isValidRow(int row) {
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < width(); ++i) {
                int value = matrix[row][i];
                if (value != 0) {
                    if (used.contains(value)) {
                        return false;
                    }
                    used.add(value);
                }
            }
            return true;
        }

        boolean isValidColumn(int column) {
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < height(); ++i) {
                int value = matrix[i][column];
                if (value != 0) {
                    if (used.contains(value)) {
                        return false;
                    }
                    used.add(value);
                }
            }
            return true;
        }

        boolean isValidChunk(int chunkRow, int chunkColumn) {
            Set<Integer> used = new HashSet<>();
            int chunkSize = 3;
            for (int i = chunkRow * 3; i < chunkRow * 3 + chunkSize; ++i) {
                for (int j = chunkColumn * 3; j < chunkColumn * 3 + chunkSize; ++j) {
                    int value = matrix[i][j];
                    if (value != 0) {
                        if (used.contains(value)) {
                            return false;
                        }
                        used.add(value);
                    }
                }
            }
            return true;
        }

        boolean isValidUpdate(int row, int column) {
            return isValidRow(row) && isValidColumn(column) && isValidChunk(row / 3, column / 3);
        }

        int width() {
            return matrix[0].length;
        }

        int height() {
            return matrix.length;
        }

        boolean trySolve(int cell) {
            if (cell == width() * height()) {
                return true;
            }

            int row = cell / width();
            int column = cell % width();

            if (matrix[row][column] == 0) {
                for (int i = 1; i < 10; ++i) {
                    matrix[row][column] = i;
                    if (isValidUpdate(row, column) && trySolve(cell + 1)) {
                        return true;
                    }
                }
                matrix[row][column] = 0;
                return false;
            } else {
                return trySolve(cell + 1);
            }
        }

        void trySolve() {
            trySolve(0);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        Sudoku sudoku = new Sudoku(matrix);
        sudoku.trySolve();
        sudoku.print();
    }
}
