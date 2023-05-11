import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]>[] listArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            listArr[start].add(new int[]{price, end});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int[] result = new int[N + 1];
            floyd(i, listArr, new boolean[N + 1], result);
            for (int j = 1; j <= N; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void floyd(int s, List<int[]>[] listArr, boolean[] check, int[] result) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        queue.add(new int[]{0, s});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int price = poll[0];
            int start = poll[1];
            if (check[start]) continue;
            check[start] = true;
            for (int[] arr : listArr[start]) {
                int newPrice = arr[0] + price;
                int end = arr[1];
                if (!check[end] && (result[end] == 0 || result[end] > newPrice)) {
                    result[end] = newPrice;
                    queue.add(new int[]{newPrice, end});
                }
            }
        }
    }
}