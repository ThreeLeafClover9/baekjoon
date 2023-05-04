import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger combination = combination(N, M);
        System.out.println(combination);
    }

    private static BigInteger combination(int n, int m) {
        if (n - m < m) m = n - m;
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
        }
        for (int i = 0; i < m; i++) {
            result = result.divide(BigInteger.valueOf(m - i));
        }
        return result;
    }
}
