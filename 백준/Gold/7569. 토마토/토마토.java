import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        List<int[][]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            int[][] matrix = new int[M][N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    matrix[i][j] = num;
                    if (num == 1) queue.add(new int[]{i, j, h});
                }
            }
            list.add(matrix);
        }
        tomato(list, M, N, H, queue);
        int max = max(list);
        System.out.println(max);
    }

    private static void tomato(List<int[][]> list, int M, int N, int H, Queue<int[]> queue) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int m = poll[0];
            int n = poll[1];
            int h = poll[2];
            int[][] matrix = list.get(h);
            for (int i = 0; i < DIR.length; i++) {
                int dirM = DIR[i][0] + m;
                int dirN = DIR[i][1] + n;
                if (checkH(h, H) && check(dirM, dirN, matrix, M, N) && matrix[dirM][dirN] == 0) {
                    matrix[dirM][dirN] = matrix[m][n] + 1;
                    queue.add(new int[]{dirM, dirN, h});
                }
            }
            int newH = h + 1;
            for (int i = 0; i < 2; i++) {
                if (i == 1) newH = h - 1;
                if (checkH(newH, H)) {
                    int[][] newMatrix = list.get(newH);
                    if (check(m, n, newMatrix, M, N) && newMatrix[m][n] == 0) {
                        newMatrix[m][n] = matrix[m][n] + 1;
                        queue.add(new int[]{m, n, newH});
                    }

                }
            }
        }
    }

    private static int max(List<int[][]> list) {
        int max = 0;
        for (int h = 0; h < list.size(); h++) {
            int[][] matrix = list.get(h);
            for (int[] ints : matrix) {
                for (int num : ints) {
                    if (num > max) max = num;
                    if (num == 0) {
                        return -1;
                    }
                }
            }
        }
        return max - 1;
    }

    private static boolean check(int m, int n, int[][] matrix, int M, int N) {
        return m >= 0 && m < M && n >= 0 && n < N && matrix[m][n] >= 0;
    }

    private static boolean checkH(int h, int H) {
        return h >= 0 && h < H;
    }
}