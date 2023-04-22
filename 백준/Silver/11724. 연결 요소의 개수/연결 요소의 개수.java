import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];
        boolean[] check = new boolean[N];
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                queue.add(i);
                logic(matrix, N, check, queue);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void logic(int[][] matrix, int N, boolean[] check, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < N; i++) {
                if (!check[i] && matrix[poll][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}