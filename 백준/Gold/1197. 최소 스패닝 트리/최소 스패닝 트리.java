import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            queue.add(new int[]{C, A, B});
        }
        long min = min(queue, V);
        System.out.println(min);
    }

    private static long min(PriorityQueue<int[]> queue, int V) {
        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        long result = 0;
        int count = 0;
        while (count < V - 1) {
            int[] poll = queue.poll();
            int weight = poll[0];
            int a = poll[1];
            int b = poll[2];
            if (union(a, b, parent)) {
                result += weight;
                count++;
            }
        }
        return result;
    }

    private static boolean union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    private static int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        else return find(parent[a], parent);
    }
}