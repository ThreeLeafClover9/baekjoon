import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] edge = new int[n + 1];
        List<Integer>[] ORDER = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            ORDER[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int next = Integer.parseInt(st.nextToken());
            int[] order = new int[next];
            for (int j = 0; j < next; j++) {
                order[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < next - 1; j++) {
                ORDER[order[j]].add(order[j + 1]);
                edge[order[j + 1]] += 1;
            }
        }
        String str = lineUp(ORDER, edge, n);
        System.out.println(str);
    }

    private static String lineUp(List<Integer>[] next, int[] edge, int N) {
        boolean[] check = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) {
                queue.add(i);
                check[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            sb.append(index).append("\n");
            for (Integer newIndex : next[index]) {
                edge[newIndex] += -1;
                if (edge[newIndex] == 0) {
                    queue.add(newIndex);
                    check[newIndex] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!check[i]) return "0";
        }
        return sb.toString();
    }
}