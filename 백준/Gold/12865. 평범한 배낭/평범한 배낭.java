import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] memo = new int[N + 1][K + 1];
        int bag = bag(matrix, N, K, memo);
        System.out.println(bag);
    }

    private static int bag(int[][] matrix, int N, int K, int[][] memo) {
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                int weight = k - matrix[i - 1][0];
                if (weight >= 0) {
                    memo[i][k] = Math.max(
                            memo[i - 1][k], memo[i - 1][weight] + matrix[i - 1][1]
                    );
                } else memo[i][k] = memo[i - 1][k];
            }
        }
        return memo[N][K];
    }
}