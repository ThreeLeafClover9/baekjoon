import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int[][] memo = new int[N][3];
            min = Math.min(min, rgbDistance(matrix, N, i, memo));
        }
        System.out.println(min);
    }

    private static int rgbDistance(int[][] matrix, int N, int start, int[][] memo) {
        for (int i = 0; i < 3; i++) {
            if (i == start) memo[1][i] = 10000;
            else memo[1][i] = matrix[0][start] + matrix[1][i];
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    min = Math.min(min, memo[i - 1][k]);
                }
                memo[i][j] = min + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == start) continue;
            min = Math.min(min, memo[N - 1][i]);
        }
        return min;
    }
}

