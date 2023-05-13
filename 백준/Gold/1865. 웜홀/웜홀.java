import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            List<int[]>[] listArr = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                listArr[i] = new ArrayList<>();
            }
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                listArr[S].add(new int[]{E, T});
                listArr[E].add(new int[]{S, T});
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                listArr[S].add(new int[]{E, -T});
            }
            boolean minusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (wormhole(i, listArr, N)) {
                    minusCycle = true;
                    break;
                }
            }
            if (minusCycle) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean wormhole(int start, List<int[]>[] listArr, int N) {
        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        for (int i = 1; i < N; i++) {
            boolean update = false;
            for (int j = 1; j <= N; j++) {
                for (int[] arr : listArr[j]) {
                    int end = arr[0];
                    int value = arr[1] + result[j];
                    if (result[j] != Integer.MAX_VALUE && result[end] > value) {
                        result[end] = value;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        for (int i = 1; i <= N; i++) {
            for (int[] arr : listArr[i]) {
                int end = arr[0];
                int value = arr[1] + result[i];
                if (result[i] != Integer.MAX_VALUE && result[end] > value) {
                    return true;
                }
            }
        }
        return false;
    }
}