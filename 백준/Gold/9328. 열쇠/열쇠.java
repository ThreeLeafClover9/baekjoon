import java.io.*;
import java.util.*;

public class Main {
    public static int h, w;
    public static int result;
    public static char[][] matrix;
    public static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            char[][] base = new char[h][w];
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    char c = str.charAt(k);
                    base[j][k] = c;
                    if ((j == 0 || j == h - 1 || k == 0 || k == w - 1) && c != '*') {
                        queue.add(new int[]{j, k});
                    }
                }
            }
            boolean[] key = new boolean[26];
            String str = br.readLine();
            if (!str.equals("0")) {
                for (int j = 0; j < str.length(); j++) {
                    int index = str.charAt(j) - 'a';
                    key[index] = true;
                }
            }
            List<int[]>[] door = new List[26];
            for (int j = 0; j < 26; j++) {
                door[j] = new ArrayList<>();
            }
            int result = 0;
            matrix = new char[h][w];
            for (int j = 0; j < h; j++) {
                System.arraycopy(base[j], 0, matrix[j], 0, w);
            }
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                result += max(poll, key, door);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int max(int[] start, boolean[] key, List<int[]>[] door) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            char point = matrix[x][y];
            if (point == '*') continue;
            if (point == '.') {
                matrix[x][y] = '*';
                move(x, y, queue);
            }  else if (point == '$') {
                matrix[x][y] = '*';
                move(x, y, queue);
                result++;
            } else if (Character.isUpperCase(point)) {
                int index = point - 'A';
                if (key[index]) {
                    matrix[x][y] = '*';
                    move(x, y, queue);
                } else {
                    door[index].add(poll);
                }
            } else {
                int index = point - 'a';
                key[index] = true;
                for (int[] arr : door[index]) {
                    int row = arr[0];
                    int col = arr[1];
                    matrix[row][col] = '*';
                    move(row, col, queue);
                }
                matrix[x][y] = '*';
                move(x, y, queue);
            }
        }
        return result;
    }

    private static void move(int x, int y, Queue<int[]> queue) {
        for (int i = 0; i < 4; i++) {
            int row = x + DIR[i][0];
            int col = y + DIR[i][1];
            if (check(row, col) && matrix[row][col] != '*') {
                queue.add(new int[]{row, col});
            }
        }
    }

    private static boolean check(int row, int col) {
        return row >= 0 && row < h && col >= 0 && col < w;
    }
}