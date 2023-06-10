import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] base = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            base[i] = Integer.parseInt(st.nextToken());
            base[i + 1] = Integer.parseInt(st.nextToken());
        }
        int[][] memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int pow = pow(0, n - 1, memo, base);
        System.out.println(pow);
    }

    private static int pow(int start, int index, int[][] memo, int[] base) {
        if(start == index) return 0;
        if(memo[start][index] != Integer.MAX_VALUE) return memo[start][index];
        for (int i = start; i < index; i++) {
            int value = pow(start, i, memo, base) + (base[start] * base[i + 1] * base[index + 1]) + pow(i + 1, index, memo, base);
            memo[start][index] = Math.min(memo[start][index], value);
        }
        return memo[start][index];
    }
}