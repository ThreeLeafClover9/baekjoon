import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[] start = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) start = new int[]{i, j, 0};
                else matrix[i][j] = -num;
            }
        }
        distance(matrix, start, N, M);
        StringBuilder sb = new StringBuilder();
        for (int[] arr : matrix) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void distance(int[][] matrix, int[] start, int N, int M) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int value = poll[2] + 1;
            for (int[] dir : DIR) {
                int row = poll[0] + dir[0];
                int col = poll[1] + dir[1];
                if (check(row, col, N, M)) {
                    if (matrix[row][col] == -1) {
                        matrix[row][col] = value;
                        queue.add(new int[]{row, col, value});
                    }
                }
            }


        }
    }

    private static boolean check(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}