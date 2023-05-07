import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N + 1][N + 1];
        int num = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = num += Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            section(N, matrix, arr, sb);
        }
        System.out.println(sb);
    }

    private static void section(int N, int[][] matrix, int[] arr, StringBuilder sb) {
        int sRow = arr[0];
        int sCol = arr[1];
        int eRow = arr[2];
        int eCol = arr[3];
        int result = 0;
        for (int i = sRow; i <= eRow; i++) {
            result += matrix[i][eCol];
            if (sCol == 1) result -= matrix[i - 1][N];
            else result -= matrix[i][sCol - 1];
        }
        sb.append(result).append("\n");
    }
}