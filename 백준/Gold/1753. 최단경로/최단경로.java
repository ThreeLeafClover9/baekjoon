import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<int[]>[] list = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{w, v});
        }
        boolean[] check = new boolean[V + 1];
        int[] result = new int[V + 1];
        route(start, list, check, result);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            int num = result[i];
            if (num == 0 && i != start) sb.append("INF");
            else sb.append(num);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void route(int start, List<int[]>[] list, boolean[] check, int[] result) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        queue.add(new int[]{0, start});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int value = poll[0];
            int index = poll[1];
            if (check[index]) continue;
            check[index] = true;
            for (int[] arr : list[index]) {
                int newValue = arr[0] + value;
                int newIndex = arr[1];
                if (!check[newIndex] && (result[newIndex] > newValue || result[newIndex] == 0)) {
                    result[newIndex] = newValue;
                    queue.add(new int[]{newValue, newIndex});
                }
            }
        }
    }
}