import java.io.*;
import java.util.*;

public class Main {
    private static int[][] matrix;
    private static int[][] memo;
    private static int max = 16_000_000;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        memo = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(memo[i], max * 2);
        }
        int min = min(0, 1);
        System.out.println(min);
    }

    private static int min(int index, int bit) {
        if (bit == (1 << n) - 1) {
            if (matrix[index][0] == 0) return max;
            return matrix[index][0];
        }
        if (memo[index][bit] != max * 2) return memo[index][bit];
        for (int i = 0; i < n; i++) {
            if ((bit & (1 << i)) == 0 && matrix[index][i] != 0) {
                memo[index][bit] = Math.min(memo[index][bit], min(i, bit | (1 << i)) + matrix[index][i]);
            }
        }
        return memo[index][bit];
    }
}