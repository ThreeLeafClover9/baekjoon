import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int up = up(matrix, N);
        int down = down(matrix, N);
        System.out.println(up + " " + down);
    }

    private static int up(int[][] matrix, int n) {
        int[][] result = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) result[i][j] = matrix[i][j];
                else {
                    int tmp = result[i - 1][j];
                    int left = j == 0 ? tmp : Math.max(tmp, result[i - 1][j - 1]);
                    int right = j == 2 ? tmp : Math.max(tmp, result[i - 1][j + 1]);
                    result[i][j] = Math.max(left, right) + matrix[i][j];
                }
            }
        }
        int num = Integer.MIN_VALUE;
        for (int i : result[n - 1]) {
            num = Math.max(num, i);
        }
        return num;
    }

    private static int down(int[][] matrix, int n) {
        int[][] result = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) result[i][j] = matrix[i][j];
                else {
                    int tmp = result[i - 1][j];
                    int left = j == 0 ? tmp : Math.min(tmp, result[i - 1][j - 1]);
                    int right = j == 2 ? tmp : Math.min(tmp, result[i - 1][j + 1]);
                    result[i][j] = Math.min(left, right) + matrix[i][j];
                }
            }
        }
        int num = Integer.MAX_VALUE;
        for (int i : result[n - 1]) {
            num = Math.min(num, i);
        }
        return num;
    }
}