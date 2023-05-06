import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[2][N];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int sticker = sticker(matrix, N);
            sb.append(sticker).append("\n");
        }
        System.out.println(sb);
    }

    private static int sticker(int[][] matrix, int n) {
        int[][] result = new int[2][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0) result[j][i] = matrix[j][i];
                else if (i == 1) result[j][i] = matrix[(j + 1) % 2][i - 1] + matrix[j][i];
                else result[j][i] = Math.max(result[(j + 1) % 2][i - 2] + matrix[j][i], result[(j + 1) % 2][i - 1] + matrix[j][i]);
            }
        }
        return Math.max(result[0][n - 1], result[1][n - 1]);
    }
}
