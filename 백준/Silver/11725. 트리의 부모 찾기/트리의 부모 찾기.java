import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        boolean[] check = new boolean[N];
        check[0] = true;
        parentTree(list, arr, check);
        for (int i = 1; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void parentTree(List<List<Integer>> list, int[] arr, boolean[] check) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{-1, 0});
        check[0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int before = poll[0];
            int parents = poll[1];
            List<Integer> parentList = list.get(parents);
            for (Integer child : parentList) {
                if (child != before) arr[child] = parents + 1;
                if (!check[child]) {
                    check[child] = true;
                    queue.add(new int[]{parents, child});
                }
            }
        }
    }
}
