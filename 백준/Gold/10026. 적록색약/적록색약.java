import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][N];
        String[][] redGreenMatrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                String s = String.valueOf(str.charAt(j));
                matrix[i][j] = s;
                if (s.equals("G")) s = "R";
                redGreenMatrix[i][j] = s;
            }
        }
        boolean[][] check = new boolean[N][N];
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int normal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    redGreenMedicine(i, j, matrix, check, DIR);
                    normal++;
                }
            }
        }
        int redGreen = 0;
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    redGreenMedicine(i, j, redGreenMatrix, check, DIR);
                    redGreen++;
                }
            }
        }
        sb.append(normal).append(" ").append(redGreen);
        System.out.println(sb);
    }

    private static void redGreenMedicine(int row, int col, String[][] matrix, boolean[][] check, int[][] DIR) {
        String str = matrix[row][col];
        for (int[] dir : DIR) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (check(newRow, newCol, matrix.length) && !check[newRow][newCol] && matrix[newRow][newCol].equals(str)) {
                check[newRow][newCol] = true;
                redGreenMedicine(newRow, newCol, matrix, check, DIR);
            }
        }
    }

    private static boolean check(int newRow, int newCol, int N) {
        return newRow >= 0 && newRow < N && newCol >= 0 && newCol < N;
    }
}