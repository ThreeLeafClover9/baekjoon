import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] T = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]>[] listArr = new List[N];
        for (int i = 0; i < N; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int L = Integer.parseInt(st.nextToken());
            listArr[A].add(new int[]{B, L});
            listArr[B].add(new int[]{A, L});
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, ground(i, listArr, T, M, N));
        }
        System.out.println(max);
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