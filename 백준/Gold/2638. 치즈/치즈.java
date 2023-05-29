import java.io.*;
import java.util.*;

public class Main {
    public static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int melt = melt(matrix, N, M);
        System.out.println(melt);
    }

    private static int melt(int[][] matrix, int N, int M) {
        int count = -1;
        boolean cheese = true;
        while (cheese) {
            outer(matrix, N, M);
            int[][] tmp = new int[N][M];
            cheese = false;
            count++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1) {
                        cheese = true;
                        if (around(i, j, N, M, matrix)) {
                            tmp[i][j] = 1;
                        }
                    }
                }
            }
            matrix = tmp;
        }
        return count;
    }

    private static void outer(int[][] matrix, int N, int M) {
        boolean[][] check = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            matrix[row][col] = 2;
            for (int[] arr : DIR) {
                int newRow = row + arr[0];
                int newCol = col + arr[1];
                if (check(newRow, newCol, N, M) && !check[newRow][newCol] && matrix[newRow][newCol] == 0) {
                    check[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static boolean around(int n, int m, int N, int M, int[][] matrix) {
        int count = 0;
        for (int[] arr : DIR) {
            int row = n + arr[0];
            int col = m + arr[1];
            if (check(row, col, N, M) && matrix[row][col] == 2) count++;
        }
        return count <= 1;
    }

    private static boolean check(int row, int col, int N, int M) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}