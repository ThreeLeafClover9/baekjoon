import java.io.*;

public class Main {
    public static long[][] base = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] fibonacci = fibonacci(base, N - 1);
        System.out.println(fibonacci[0][0]);
    }

    private static long[][] fibonacci(long[][] matrix, long n) {
        if (n <= 1) return matrix;
        long[][] fibonacci = fibonacci(matrix, n / 2);
        if (n % 2 == 0) return pow(fibonacci, fibonacci);
        else return pow(pow(fibonacci, fibonacci), base);
    }

    public static long[][] pow(long[][] matrix1, long[][] matrix2) {
        int MOD = 1000000007;
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] %= MOD;
            }
        }
        return result;
    }
}

