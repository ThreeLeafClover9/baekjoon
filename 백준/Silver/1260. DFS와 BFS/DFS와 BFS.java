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
        int V = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            matrix[start - 1][end - 1] = 1;
            matrix[end - 1][start - 1] = 1;
        }
        String dfs = dfs(matrix, V - 1, new boolean[N]);
        System.out.println(dfs);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V - 1);
        String bfs = bfs(matrix, queue, new boolean[N]);
        System.out.println(bfs);
    }

    private static String bfs(int[][] matrix, Queue<Integer> queue, boolean[] check) {
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!check[poll]) {
                result.append(poll + 1).append(" ");
                check[poll] = true;
            }
            for (int i = 0; i < matrix.length; i++) {
                if (!check[i] && matrix[poll][i] == 1) {
                    queue.add(i);
                }
            }
        }
        return result.toString();
    }

    private static String dfs(int[][] matrix, int v, boolean[] check) {
        StringBuilder result = new StringBuilder();
        if (!check[v]) {
            result.append(v + 1).append(" ");
            check[v] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check[i] && matrix[v][i] == 1) {
                result.append(dfs(matrix, i, check));
            }
        }
        return result.toString();
    }
}