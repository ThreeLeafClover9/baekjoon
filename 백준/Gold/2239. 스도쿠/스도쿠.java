import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[9][9];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = str.charAt(j) - '0';
                matrix[i][j] = num;
                if (num == 0) list.add(new int[]{i, j});
            }
        }
        sudoku(matrix, list, 0);
        StringBuilder sb = new StringBuilder();
        for (int[] arr : matrix) {
            for (int i : arr) {
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean sudoku(int[][] matrix, List<int[]> list, int index) {
        if (index >= list.size()) return true;
        int[] arr = list.get(index);
        int row = arr[0];
        int col = arr[1];
        for (int i = 1; i <= 9; i++) {
            if (check(matrix, row, col, i)) {
                matrix[row][col] = i;
                if (sudoku(matrix, list, index + 1)) return true;
            }
        }
        matrix[row][col] = 0;
        return false;
    }

    private static boolean check(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) return false;
        }
        int ROW = row / 3 * 3;
        int COL = col / 3 * 3;
        for (int i = ROW; i < ROW + 3; i++) {
            for (int j = COL; j < COL + 3; j++) {
                if (matrix[i][j] == num) return false;
            }
        }
        return true;
    }
}