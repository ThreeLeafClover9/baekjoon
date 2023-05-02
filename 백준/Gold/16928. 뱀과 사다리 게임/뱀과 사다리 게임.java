import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        int[] DIR = {1, 2, 3, 4, 5, 6};
        boolean[] check = new boolean[106];
        int ladder = ladder(map, queue, DIR, check);
        System.out.println(ladder);
    }

    private static int ladder(Map<Integer, Integer> map, Queue<int[]> queue, int[] DIR, boolean[] check) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int count = poll[1];
            if (map.containsKey(index)) index = map.get(index);
            if (index == 100) return count;
            for (int i = 0; i < 6; i++) {
                int newIndex = index + DIR[i];
                if (!check[newIndex]) {
                    queue.add(new int[]{newIndex, count + 1});
                    check[newIndex] = true;
                }
            }
        }
        return 0;
    }
}