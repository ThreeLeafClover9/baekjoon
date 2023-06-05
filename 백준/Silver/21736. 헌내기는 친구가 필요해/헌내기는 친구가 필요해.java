import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[] start = new int[0];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'I') {
                    start = new int[]{i, j};
                } else if (c == 'P') {
                    list.add(new int[]{i, j});
                } else if (c == 'X') {
                    matrix[i][j] = -1;
                }
            }
        }
        int count = count(matrix, start, list, N, M);
        System.out.println(count == 0 ? "TT" : count);
    }

    private static int count(int[][] matrix, int[] start, List<int[]> list, int N,int M) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] arr : DIR) {
                int row = poll[0] + arr[0];
                int col = poll[1] + arr[1];
                if (check(row, col, N, M)) {
                    if (matrix[row][col] == 0) {
                        matrix[row][col] = 1;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
        int count = 0;
        for (int[] arr : list) {
            if (matrix[arr[0]][arr[1]] == 1) count++;
        }
        return count;
    }

    private static boolean check(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}