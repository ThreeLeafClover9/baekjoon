import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<int[]>[] listArr = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            listArr[start].add(new int[]{end, weight});
            listArr[end].add(new int[]{start, weight});
        }
        st = new StringTokenizer(br.readLine());
        int path1 = Integer.parseInt(st.nextToken());
        int path2 = Integer.parseInt(st.nextToken());
        int num1 = path(1, path1, listArr, N);
        num1 += path(path1, path2, listArr, N);
        num1 += path(path2, N, listArr, N);
        int num2 = path(1, path2, listArr, N);
        num2 += path(path2, path1, listArr, N);
        num2 += path(path1, N, listArr, N);
        int min = Math.min(num1, num2);
        System.out.println((min >= 200000000) ? -1 : min);
    }

    private static int path(int start, int end, List<int[]>[] listArr, int N) {
        int[] result = new int[N + 1];
        Arrays.fill(result, 200000000);
        result[start] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        for (int[] arr : listArr[start]) {
            int tmp = arr[0];
            int weight = arr[1];
            queue.add(new int[]{weight, tmp});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int tmp = poll[1];
            int weight = poll[0];
            if (result[tmp] > weight) {
                result[tmp] = weight;
                for (int[] arr : listArr[tmp]) {
                    int newEnd = arr[0];
                    int newWeight = arr[1] + weight;
                    queue.add(new int[]{newWeight, newEnd});
                }
            }
        }
        return result[end];
    }
}