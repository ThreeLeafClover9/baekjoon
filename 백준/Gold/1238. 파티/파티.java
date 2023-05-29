import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<int[]>[] listArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            listArr[start].add(new int[]{end, time});
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, length(i, X, listArr, N) + length(X, i, listArr, N));
        }
        System.out.println(max);
    }

    private static int length(int start, int end, List<int[]>[] listArr, int N) {
        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int length = poll[1];
            for (int[] arr : listArr[index]) {
                int newIndex = arr[0];
                int newLength = length + arr[1];
                if (result[newIndex] > newLength) {
                    result[newIndex] = newLength;
                    queue.add(new int[]{newIndex, newLength});
                }
            }
        }
        return result[end];
    }

    private static int path(int start, int end, List<int[]>[] listArr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        queue.add(new int[]{0, start});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int weight = poll[0];
            int tmp = poll[1];
            if (tmp == end) return weight;
            for (int[] arr : listArr[tmp]) {
                int newWeight = weight + arr[0];
                int newEnd = arr[1];
                queue.add(new int[]{newWeight, newEnd});
            }
        }
        return 0;
    }

    private static int ground(int start, List<int[]>[] listArr, int[] T, int M, int N) {
        int num = 0;
        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        boolean[] check = new boolean[N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int weight = poll[1];
            if (!check[index]) {
                check[index] = true;
                num += T[index];
            }
            if (result[index] > weight) result[index] = weight;
            for (int[] arr : listArr[index]) {
                int newIndex = arr[0];
                int newWeight = weight + arr[1];
                if (newWeight <= M && result[newIndex] > newWeight) {
                    queue.add(new int[]{newIndex, newWeight});
                }
            }
        }
        return num;
    }
}