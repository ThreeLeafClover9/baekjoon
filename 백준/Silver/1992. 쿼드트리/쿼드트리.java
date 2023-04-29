import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split("");
        }
        String quadTree = quadTree(0, 0, N, matrix);
        System.out.println(quadTree);
    }

    private static String quadTree(int row, int col, int len, String[][] matrix) {
        String result = "";
        if(check(row, col, len, matrix)) result = matrix[row][col];
        else {
            int newLen = len / 2;
            result += "(";
            result += quadTree(row, col, newLen, matrix);
            result += quadTree(row, col + newLen, newLen, matrix);
            result += quadTree(row + newLen, col, newLen, matrix);
            result += quadTree(row + newLen, col + newLen, newLen, matrix);
            result += ")";
        }
        return result;
    }

    private static boolean check(int row, int col, int len, String[][] matrix) {
        String str = matrix[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (!matrix[i][j].equals(str)) return false;
            }
        }
        return true;
    }
}