import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int[] arr : matrix) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int price = Integer.parseInt(st.nextToken());
            matrix[start][end] = Math.min(matrix[start][end], price);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        boolean[] check = new boolean[N];
        int minimumCost = minimumCost(start, end, matrix, check, N);
        System.out.println(minimumCost);
    }

    private static int minimumCost(int start, int end, int[][] matrix, boolean[] check, int N) {
        check[start] = true;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        for (int i = 0; i < N; i++) {
            if (matrix[start][i] != Integer.MAX_VALUE) queue.add(new int[]{matrix[start][i], i});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int price = poll[0];
            int index = poll[1];
            check[index] = true;
            for (int i = 0; i < N; i++) {
                if (check[i]) continue;
                if (matrix[index][i] != Integer.MAX_VALUE) {
                    if (price + matrix[index][i] < matrix[start][i]) {
                        matrix[start][i] = price + matrix[index][i];
                        queue.add(new int[]{price + matrix[index][i], i});
                    }
                }
            }
        }
        return matrix[start][end];
    }
}