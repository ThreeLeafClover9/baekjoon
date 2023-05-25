import java.io.*;
import java.util.*;

public class Main {
    public static long[][] base;
    public static int MOD = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        base = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                base[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        StringBuilder sb = new StringBuilder();
        long[][] square = square(base, N, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(square[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static long[][] square(long[][] matrix, int n, long b) {
        if (b <= 1) return matrix;
        long[][] square = square(matrix, n, b / 2);
        if (b % 2 == 0) return pow(square, square, n);
        else return pow(pow(square, square, n), base, n);
    }

    private static long[][] pow(long[][] matrix1, long[][] matrix2, int n) {
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] %= MOD;
            }
        }
        return result;
    }
}