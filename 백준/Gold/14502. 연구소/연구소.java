import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        boolean[][] check = new boolean[N][M];
        int laboratory = laboratory(matrix, queue, check, N, M, 0);
        System.out.println(laboratory);
    }

    private static int laboratory(int[][] matrix, Queue<int[]> queue, boolean[][] check, int N, int M, int step) {
        int result = 0;
        if (step == 3) {
            int[][] newMatrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, M);
            }
            Queue<int[]> newQueue = new LinkedList<>(queue);
            return count(newMatrix, newQueue, N, M);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j] && matrix[i][j] == 0) {
                    check[i][j] = true;
                    matrix[i][j] = 1;
                    result = Math.max(result, laboratory(matrix, queue, check, N, M, step + 1));
                    matrix[i][j] = 0;
                    check[i][j] = false;
                }
            }
        }
        return result;
    }

    private static int count(int[][] matrix, Queue<int[]> queue, int N, int M) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int n = poll[0];
            int m = poll[1];
            for (int[] ints : DIR) {
                int dirN = ints[0] + n;
                int dirM = ints[1] + m;
                if (check(dirN, dirM, N, M) && (matrix[dirN][dirM] == 0 || matrix[dirN][dirM] > matrix[n][m] + 1)) {
                    matrix[dirN][dirM] = matrix[n][m] + 1;
                    queue.add(new int[]{dirN, dirM});
                }
            }
        }
        int count = 0;
        for (int[] arr : matrix) {
            for (int i : arr) {
                if (i == 0) count++;
            }
        }
        return count;
    }

    private static boolean check(int n, int m, int N, int M) {
        return n >= 0 && n < N && m >= 0 && m < M;
    }
}