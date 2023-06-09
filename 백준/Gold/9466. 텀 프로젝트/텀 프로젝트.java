import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] edge = new int[n + 1];
            int[] next = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                edge[num] += 1;
                next[j] = num;
            }
            sb.append(count(edge, next, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int count(int[] edge, int[] next, int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edge[i] == 0) queue.add(i);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int nextIndex = next[index];
            edge[nextIndex] -= 1;
            result++;
            if (edge[nextIndex] == 0) queue.add(nextIndex);
        }
        return result;
    }
}