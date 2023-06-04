import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] before = new int[N + 1];
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] next = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            next[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            next[A].add(B);
            before[B] += 1;
        }
        String lineUp = lineUp(next, before, N);
        System.out.println(lineUp);
    }

    private static String lineUp(List<Integer>[] next, int[] edge, int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            sb.append(index).append(" ");
            for (Integer newIndex : next[index]) {
                edge[newIndex] += -1;
                if (edge[newIndex] == 0) queue.add(newIndex);
            }
        }
        return sb.toString();
    }
}

