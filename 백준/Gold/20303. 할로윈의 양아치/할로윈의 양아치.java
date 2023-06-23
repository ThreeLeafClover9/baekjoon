import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            lists[a].add(b);
            lists[b].add(a);
        }
        int[][] matrix = cycle(lists, n, candy);
        int max = max(matrix, matrix.length, k);
        System.out.println(max);
    }

    private static int[][] cycle(List<Integer>[] lists, int n, int[] candy) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<int[]> result = new LinkedList<>();
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            queue.add(i);
            check[i] = true;
            int sum = 0;
            int count = 0;
            while (!queue.isEmpty()) {
                Integer index = queue.poll();
                sum += candy[index];
                count++;
                for (Integer next : lists[index]) {
                    if (!check[next]) {
                        queue.add(next);
                        check[next] = true;
                    }
                }
            }
            result.add(new int[]{sum, count});
        }
        int[][] matrix = new int[result.size()][2];
        int i = 0;
        while (!result.isEmpty()) {
            matrix[i] = result.poll();
            i++;
        }
        return matrix;
    }

    private static int max(int[][] matrix, int n, int max) {
        int[][] memo = new int[n + 1][max];
        for (int k = 1; k < max; k++) {
            for (int i = 1; i <= n; i++) {
                int cost = k - matrix[i - 1][1];
                if (cost >= 0) {
                    memo[i][k] = Math.max(memo[i - 1][k], memo[i - 1][cost] + matrix[i - 1][0]);
                } else memo[i][k] = memo[i - 1][k];
            }
        }
        return memo[n][max - 1];
    }
}