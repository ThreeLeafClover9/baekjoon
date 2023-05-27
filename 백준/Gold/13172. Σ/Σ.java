import java.io.*;
import java.util.*;

public class Main {
    public static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        long N = 1;
        long S = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            S = s * N + S * n;
            N *= n;
            S %= MOD;
            N %= MOD;
        }
        if (S % N == 0) {
            System.out.println(S / N);
        } else {
            long fermat = S * fermat(N, MOD - 2) % MOD;
            System.out.println(fermat);
        }
    }

    private static long fermat(long num, int exponent) {
        if (exponent <= 1) return num;
        long fermat = fermat(num, exponent / 2);
        if (exponent % 2 == 0) return fermat * fermat % MOD;
        else return fermat * fermat % MOD * num % MOD;
    }
}