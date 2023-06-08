import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] M = new int[n + 1];
        int[] C = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            M[i] = Integer.parseInt(st1.nextToken());
            max += C[i] = Integer.parseInt(st2.nextToken());
        }
        int[][] memo = new int[n + 1][max + 1];
        min(M, C, memo, n, max);
        for (int i = 0; i <= max; i++) {
            if (memo[n][i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void min(int[] M, int[] C, int[][] memo, int n, int max) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= max; j++) {
                memo[i][j] = memo[i - 1][j];
                int newCost = j - C[i];
                if (newCost >= 0) {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][newCost] + M[i]);
                }
            }
        }
    }
}