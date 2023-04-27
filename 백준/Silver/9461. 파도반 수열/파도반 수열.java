import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long wave = wave(n);
            sb.append(wave).append("\n");
        }
        System.out.println(sb);
    }

    private static long wave(int n) {
        long[] result = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 3) result[i] = 1;
            else if (i == 4) result[i] = 2;
            else result[i] = result[i - 1] + result[i - 5];
        }
        return result[n];
    }
}