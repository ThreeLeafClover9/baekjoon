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
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        boolean[][] check = new boolean[N][M];
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        labyrinthSearch(queue, matrix, DIR, N, M, check);
        System.out.println(matrix[N - 1][M - 1]);
    }

    private static void labyrinthSearch(Queue<int[]> queue, int[][] matrix, int[][] DIR, int N, int M, boolean[][] check) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            int num = poll[2];
            if (matrix[row][col] == 1) matrix[row][col] = num;
            for (int i = 0; i < 4; i++) {
                int newRow = DIR[i][0] + row;
                int newCol = DIR[i][1] + col;
                if (check(newRow, newCol, N, M) && !check[newRow][newCol] && matrix[newRow][newCol] != 0) {
                    check[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, num + 1});
                }
            }
        }
    }

    private static boolean check(int newRow, int newCol, int N, int M) {
        return newRow >= 0 && newRow < N && newCol >= 0 && newCol < M;
    }
}