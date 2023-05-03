import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = Integer.MIN_VALUE;
        boolean[][] check = new boolean[N][M];
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    num = Math.max(num, tetromino(i, j, matrix, N, M, DIR, check, 0, 0));
                    check[i][j] = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                num = Math.max(num, nsew(i, j, matrix, DIR, N, M));
            }
        }
        System.out.println(num);
    }

    private static int nsew(int row, int col, int[][] matrix, int[][] DIR, int N, int M) {
        int num = matrix[row][col];
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIR[i][0];
            int newCol = col + DIR[i][1];
            if (check(newRow, newCol, N, M)) {
                num += matrix[newRow][newCol];
            }
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIR[i][0];
            int newCol = col + DIR[i][1];
            if (check(newRow, newCol, N, M)) {
                result = Math.max(result, num - matrix[newRow][newCol]);
            } else result = Math.max(result, num);
        }
        return result;
    }

    private static int tetromino(int row, int col, int[][] matrix, int N, int M, int[][] DIR, boolean[][] check, int sum, int depth) {
        int num = 0;
        if (depth == 4) return sum;
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIR[i][0];
            int newCol = col + DIR[i][1];
            if (check(newRow, newCol, N, M) && !check[newRow][newCol]) {
                check[newRow][newCol] = true;
                num = Math.max(num, tetromino(newRow, newCol, matrix, N, M, DIR, check, sum + matrix[newRow][newCol], depth + 1));
                check[newRow][newCol] = false;
            }
        }
        return num;
    }

    private static boolean check(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}