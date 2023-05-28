import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[R][C];
        List<Integer> cleaner = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    cleaner.add(i);
                } else matrix[i][j] = num;
            }
        }
        matrix = spread(matrix, cleaner, R, C, T);
        int dust = 0;
        for (int[] arr : matrix) {
            for (int i : arr) {
                dust += i;
            }
        }
        System.out.println(dust);
    }

    private static int[][] spread(int[][] matrix, List<Integer> cleaner, int R, int C, int T) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < T; i++) {
            int[][] tmp = new int[R][C];
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (matrix[row][col] != 0) {
                        int dust = matrix[row][col];
                        int spread = dust / 5;
                        tmp[row][col] += dust - spread * dirNum(row, col, R, C, DIR, cleaner);
                        for (int[] dir : DIR) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            if (check(newRow, newCol, R, C, cleaner)) {
                                tmp[newRow][newCol] += spread;
                            }
                        }
                    }
                }
            }
            Integer integer = cleaner.get(0);
            for (int j = integer - 2; j >= 0; j--) {
                tmp[j + 1][0] = tmp[j][0];
            }
            for (int j = 1; j < C; j++) {
                tmp[0][j - 1] = tmp[0][j];
            }
            for (int j = 1; j <= integer; j++) {
                tmp[j - 1][C - 1] = tmp[j][C - 1];
            }
            for (int j = C - 2; j >= 0; j--) {
                tmp[integer][j + 1] = tmp[integer][j];
            }
            integer = cleaner.get(1);
            for (int j = integer + 2; j < R; j++) {
                tmp[j - 1][0] = tmp[j][0];
            }
            for (int j = 1; j < C; j++) {
                tmp[R - 1][j - 1] = tmp[R - 1][j];
            }
            for (int j = R - 2; j >= integer; j--) {
                tmp[j + 1][C - 1] = tmp[j][C - 1];
            }
            for (int j = C - 2; j >= 0; j--) {
                tmp[integer][j + 1] = tmp[integer][j];
            }
            matrix = tmp;
        }
        return matrix;
    }

    private static int dirNum(int row, int col, int R, int C, int[][] dir, List<Integer> cleaner) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (check(row + dir[i][0], col + dir[i][1], R, C, cleaner)) count++;
        }
        return count;
    }

    private static boolean check(int r, int c, int R, int C, List<Integer> cleaner) {
        return r >= 0 && r < R && c >= 0 && c < C && (r != cleaner.get(0) || c != 0) && (r != cleaner.get(1) || c != 0);
    }
}