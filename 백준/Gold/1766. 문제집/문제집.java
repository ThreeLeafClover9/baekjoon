import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] before = new int[n];
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            lists[a].add(b);
            before[b] += 1;
        }
        String order = order(lists, before, n);
        System.out.println(order);
    }

    private static String order(List<Integer>[] lists, int[] before, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (before[i] == 0) queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll + 1).append(" ");
            for (Integer next : lists[poll]) {
                before[next] -= 1;
                if (before[next] == 0) queue.add(next);
            }
        }
        return sb.toString();
    }
}