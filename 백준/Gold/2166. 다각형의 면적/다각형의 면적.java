import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] X = new long[N];
        long[] Y = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        double area = area(X, Y, N);
        System.out.printf("%.1f", area);
    }

    private static double area(long[] X, long[] Y, int N) {
        long sum = 0;
        long x1 = X[0];
        long y1 = Y[0];
        for (int i = 1; i < N - 1; i++) {
            long x2 = X[i];
            long y2 = Y[i];
            long x3 = X[i + 1];
            long y3 = Y[i + 1];
            sum += (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2);
        }
        return Math.abs(sum / 2.0);
    }
}