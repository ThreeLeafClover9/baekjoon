import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        int cycle = cycle(list, N);
        System.out.println(cycle);
    }

    private static int cycle(List<int[]> list, int N) {
        int[] parent = new int[N];
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            int a = arr[0];
            int b = arr[1];
            if (union(a, b, parent)) return i + 1;
        }
        return 0;
    }

    private static boolean union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);
        if (a == b) {
            return true;
        }
        parent[b] = a;
        return false;
    }

    private static int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        else return find(parent[a], parent);
    }
}

