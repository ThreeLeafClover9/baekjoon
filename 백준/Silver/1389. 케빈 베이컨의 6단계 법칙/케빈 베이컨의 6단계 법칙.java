import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            matrix[A][B] = 1;
            matrix[B][A] = 1;
        }
        for (int i = 0; i < N; i++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, 0});
            boolean[] check = new boolean[N];
            check[i] = true;
            sixStepLaw(i, matrix, N, queue, check);
        }
        int lower = lower(matrix, N);
        System.out.println(lower);
    }

    private static void sixStepLaw(int start, int[][] matrix, int N, Queue<int[]> queue, boolean[] check) {
        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int step = poll[1];
            count += step;
            for (int i = 0; i < N; i++) {
                int num = matrix[index][i];
                if (num == 1 && !check[i]) {
                    check[i] = true;
                    queue.add(new int[]{i, step + 1});
                }
            }
        }
        matrix[start][start] = count;
    }

    private static int lower(int[][] matrix, int N) {
        int result = matrix[0][0];
        int index = 0;
        for (int i = 1; i < N; i++) {
            int num = matrix[i][i];
            if (result > num) {
                result = num;
                index = i;
            }
        }
        return index + 1;
    }
}