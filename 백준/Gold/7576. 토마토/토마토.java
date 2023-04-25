import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[M][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 1) queue.add(new int[]{i, j});
            }
        }
        logic(matrix, M, N, queue);
        int result = 0;
        outer:
        for (int[] ints : matrix) {
            for (int num : ints) {
                if (num > result) result = num;
                if (num == 0) {
                    result = 0;
                    break outer;
                }
            }
        }
        System.out.println(result - 1);
    }

    private static void logic(int[][] matrix, int M, int N, Queue<int[]> queue) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int m = poll[0];
            int n = poll[1];
            for (int i = 0; i < DIR.length; i++) {
                int dirM = DIR[i][0] + m;
                int dirN = DIR[i][1] + n;
                if (check(dirM, dirN, matrix, M, N) && (matrix[dirM][dirN] == 0 || matrix[dirM][dirN] > matrix[m][n] + 1)) {
                    matrix[dirM][dirN] = matrix[m][n] + 1;
                    queue.add(new int[]{dirM, dirN});
                }
            }
        }
    }

    private static boolean check(int m, int n, int[][] matrix, int M, int N) {
        return m >= 0 && m < M && n >= 0 && n < N && matrix[m][n] >= 0;
    }
}