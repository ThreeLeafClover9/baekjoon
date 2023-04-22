import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String[][] matrix = new String[next][next];
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            matrix[i] = str.split(" ");
        }
        System.out.println(logic(0, 0, next, matrix, "0"));
        System.out.println(logic(0, 0, next, matrix, "1"));
    }

    private static int logic(int row, int col, int len, String[][] matrix, String value) {
        if (len == 1) return matrix[row][col].equals(value) ? 1 : 0;
        int count = 0;
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (!matrix[i][j].equals(value)) {
                    int half = len / 2;
                    count += logic(row, col, half, matrix, value);
                    count += logic(row, col + half, half, matrix, value);
                    count += logic(row + half, col, half, matrix, value);
                    count += logic(row + half, col + half, half, matrix, value);
                    return count;
                }
            }
        }
        return ++count;
    }
}