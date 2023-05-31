import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] arr = new String[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().split("");
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put(arr[0][0], true);
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int max = max(0, 0, 1, arr, map, DIR, R, C);
        System.out.println(max);
    }

    private static int max(int row, int col, int value, String[][] arr, Map<String, Boolean> map, int[][] DIR, int R, int C) {
        int result = value;
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIR[i][0];
            int newCol = col + DIR[i][1];
            if (check(newRow, newCol, R, C)) {
                String s = arr[newRow][newCol];
                if (!map.containsKey(s)) {
                    map.put(s, true);
                    result = Math.max(result, max(newRow, newCol, value + 1, arr, map, DIR, R, C));
                    map.remove(s);
                }
            }
        }
        return result;
    }

    private static boolean check(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}