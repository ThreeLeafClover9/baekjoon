import java.io.*;
import java.util.*;

public class Main {
    public static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        matrix = new char[n][m];
        int[] b = null;
        int[] r = null;
        int[] o = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'B') b = new int[]{i, j};
                else if (c == 'R') r = new int[]{i, j};
                else if (c == 'O') o = new int[]{i, j};
                matrix[i][j] = c;
            }
        }
        int count = count(b, r, o, n, m);
        System.out.println(count);
    }

    private static int count(int[] b, int[] r, int[] o, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r[0], r[1], b[0], b[1], -1, -1, 0});
        int result = -1;
        outer:
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[6] == 10) break;
            inner:
            for (int i = 0; i < 4; i++) {
                boolean check = false;
                boolean move = false;
                int rx = poll[0];
                int ry = poll[1];
                int rc = 0;
                if (checkDir(rx, ry, poll[4], poll[5], i)) {
                    move = true;
                    while (matrix[rx + DIR[i][0]][ry + DIR[i][1]] != '#') {
                        if (matrix[rx + DIR[i][0]][ry + DIR[i][1]] == 'O') {
                            check = true;
                            break;
                        }
                        rx += DIR[i][0];
                        ry += DIR[i][1];
                        rc++;
                    }
                }
                int bx = poll[2];
                int by = poll[3];
                int bc = 0;
                if (checkDir(bx, by, poll[4], poll[5], i)) {
                    move = true;
                    while (matrix[bx + DIR[i][0]][by + DIR[i][1]] != '#') {
                        if (matrix[bx + DIR[i][0]][by + DIR[i][1]] == 'O') {
                            continue inner;
                        }
                        bx += DIR[i][0];
                        by += DIR[i][1];
                        bc++;
                    }
                }
                if (rx == bx && ry == by) {
                    if (rc < bc) {
                        bx -= DIR[i][0];
                        by -= DIR[i][1];
                    } else if (bc < rc) {
                        rx -= DIR[i][0];
                        ry -= DIR[i][1];
                    }
                }
                if (check) {
                    result = poll[6] + 1;
                    break outer;
                }
                if (move) queue.add(new int[]{rx, ry, bx, by, DIR[i][0], DIR[i][1] , poll[6] + 1});
            }
        }
        return result;
    }

    private static boolean checkDir(int x, int y, int dirX, int dirY, int i) {
        if ((dirX == 0 && i % 2 == 1) || (dirY == 0 && i % 2 == 0)) return false;
        int newX = DIR[i][0] + x;
        int newY = DIR[i][1] + y;
        if (matrix[newX][newY] != '#') return true;
        return false;
    }
}