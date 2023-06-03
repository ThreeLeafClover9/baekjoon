import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] TIME = new int[N];
            for (int j = 0; j < N; j++) {
                TIME[j] = Integer.parseInt(st.nextToken());
            }

            int[] edge = new int[N];
            List<Integer>[] listArr = new List[N];
            for (int j = 0; j < N; j++) {
                listArr[j] = new ArrayList<>();
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                edge[Y] += 1;
                listArr[X].add(Y);
            }
            int W = Integer.parseInt(br.readLine()) - 1;
            int topological = topological(edge, N, listArr, TIME, W);
            sb.append(topological).append("\n");
        }
        System.out.println(sb);
    }

    private static int topological(int[] edge, int N, List<Integer>[] listArr, int[] TIME, int W) {
        int[] result = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            result[i] = TIME[i];
            if (edge[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (Integer newIndex : listArr[index]) {
                edge[newIndex] += -1;
                result[newIndex] = Math.max(result[newIndex], result[index] + TIME[newIndex]);
                if (edge[newIndex] == 0) queue.add(newIndex);
            }
        }
        return result[W];
    }
}

