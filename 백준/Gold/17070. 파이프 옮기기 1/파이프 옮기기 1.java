import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] DIR = {{0, 1}, {1, 1}, {1, 0}};
        int move = move(0, 1, 0, matrix, DIR, N);
        System.out.println(move);
    }

    private static int move(int row, int col, int dir, int[][] matrix, int[][] DIR, int N) {
        int result = 0;
        if (row == N - 1 && col == N - 1) return 1;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(i - dir) == 2) continue;
            int newRow = row + DIR[i][0];
            int newCol = col + DIR[i][1];
            int newDir = i;
            if (check(newRow, newCol, N)) {
                if (matrix[newRow][newCol] == 1) continue;
                if (newDir == 1 && (matrix[newRow - 1][newCol] == 1 || matrix[newRow][newCol - 1] == 1)) continue;
                result += move(newRow, newCol, newDir, matrix, DIR, N);
            }
        }
        return result;
    }

    private static boolean check(int newRow, int newCol, int N) {
        return newRow < N && newCol < N;
    }
}