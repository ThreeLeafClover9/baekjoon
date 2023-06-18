import java.io.*;
import java.util.*;

public class Main {
    public static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = count(n);
        System.out.println(count);
    }

    private static long count(int n) {
        long[][][] memo = new long[n + 1][10][1 << 10];
        for (int i = 1; i <= 9; i++) {
            memo[1][i][1 << i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (j == 0) memo[i][j][1 << j | k] = (memo[i][j][1 << j | k] + memo[i - 1][j + 1][k]) % MOD;
                    else if (j == 9) memo[i][j][1 << j | k] = (memo[i][j][1 << j | k] + memo[i - 1][j - 1][k]) % MOD;
                    else memo[i][j][1 << j | k] = (memo[i][j][1 << j | k] + memo[i - 1][j - 1][k] + memo[i - 1][j + 1][k]) % MOD;
                }
            }
        }
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + memo[n][i][(1 << 10) - 1]) % MOD;
        }
        return result;
    }
}