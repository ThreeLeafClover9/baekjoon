import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        int count = count(matrix, n, m);
        System.out.println(count);
    }

    private static int count(char[][] matrix, int n, int m) {
        Set<List<Integer>> set = new HashSet<>();
        int count = 0;
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    count += move(matrix, check, i, j, set);
                }
            }
        }
        return count;
    }

    private static int move(char[][] matrix, boolean[][] check, int sRow, int sCol, Set<List<Integer>> before) {
        Set<List<Integer>> set = new HashSet<>();
        int row = sRow;
        int col = sCol;
        while (!check[row][col]) {
            set.add(List.of(row, col));
            check[row][col] = true;
            char c = matrix[row][col];
            switch (c) {
                case 'U':
                    row -= 1;
                    break;
                case 'R':
                    col += 1;
                    break;
                case 'D':
                    row += 1;
                    break;
                case 'L':
                    col -= 1;
            }
        }
        List<Integer> b = List.of(row, col);
        if (before.contains(b)) {
            before.addAll(set);
            return 0;
        }
        else {
            before.addAll(set);
            return 1;
        }
    }
}