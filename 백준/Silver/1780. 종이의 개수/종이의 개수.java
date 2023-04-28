import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split(" ");
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("-1", 0);
        map.put("0", 0);
        map.put("1", 0);
        numberOfPaper(0, 0, matrix, N, map);
        System.out.println(map.get("-1"));
        System.out.println(map.get("0"));
        System.out.println(map.get("1"));
    }

    private static void numberOfPaper(int row, int col, String[][] matrix, int len, Map<String , Integer> map) {
        if (!check(row, col, matrix, len, map)) {
            int newLen = len / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    numberOfPaper(row + newLen * i, col + newLen * j, matrix, newLen, map);
                }
            }
        }
    }

    private static boolean check(int row, int col, String[][] matrix, int len, Map<String, Integer> map) {
        String str = matrix[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (!str.equals(matrix[i][j])) return false;
            }
        }
        map.put(str, map.get(str) + 1);
        return true;
    }
}