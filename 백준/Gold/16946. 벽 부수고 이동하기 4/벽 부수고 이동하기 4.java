import java.io.*;
import java.util.*;

public class Main {
    private static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][] matrix;
    private static int key = 1;
    private static boolean[][] check;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = -(str.charAt(j) - '0');
            }
        }
        check = new boolean[n][m];
        int[][] result = new int[n][m];
        breakWall(n, m, result);
        StringBuilder sb = new StringBuilder();
        for (int[] arr : result) {
            for (int i : arr) {
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void breakWall(int n, int m, int[][] result) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    int num = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int row = DIR[k][0] + i;
                        int col = DIR[k][1] + j;
                        if (check(row, col, n, m) && matrix[row][col] != -1) {
                            set.add(count(row, col, n, m));
                        }
                    }
                    for (Integer integer : set) {
                        num += map.get(integer);
                    }
                    result[i][j] = num % 10;
                }
            }
        }
    }

    private static int count(int row, int col, int n, int m) {
        if (matrix[row][col] != 0) return matrix[row][col];
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        check[row][col] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            matrix[poll[0]][poll[1]] = key;
            for (int i = 0; i < 4; i++) {
                int newRow = DIR[i][0] + poll[0];
                int newCol = DIR[i][1] + poll[1];
                if (check(newRow, newCol, n, m) && !check[newRow][newCol] && matrix[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    check[newRow][newCol] = true;
                    count++;
                }
            }
        }
        map.put(key, count);
        key++;
        return matrix[row][col];
    }

    private static boolean check(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}