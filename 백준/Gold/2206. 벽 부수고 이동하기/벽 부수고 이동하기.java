import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        int breakWall = breakWall(matrix, N, M);
        System.out.println(breakWall);
    }

    private static int breakWall(int[][] matrix, int N, int M) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            int count = poll[2];
            int breakWall = poll[3];
            if (row + 1 == N && col + 1 == M) return Math.abs(count);
            for (int i = 0; i < 4; i++) {
                int newRow = row + DIR[i][0];
                int newCol = col + DIR[i][1];
                if (check(newRow, newCol, N, M)) {
                    int next = matrix[newRow][newCol];
                    if (breakWall == 1) {
                        int newCount = count + 1;
                        if (next == 1) {
                            queue.add(new int[]{newRow, newCol, -newCount, 0});
                            matrix[newRow][newCol] = Integer.MAX_VALUE;
                        }
                        if (next <= 0 || (next > newCount && next != Integer.MAX_VALUE)) {
                            queue.add(new int[]{newRow, newCol, newCount, breakWall});
                            matrix[newRow][newCol] = newCount;
                        }
                    } else {
                        int newCount = count - 1;
                        if (next == 0 || next < newCount) {
                            queue.add(new int[]{newRow, newCol, newCount, breakWall});
                            matrix[newRow][newCol] = newCount;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean check(int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }
}