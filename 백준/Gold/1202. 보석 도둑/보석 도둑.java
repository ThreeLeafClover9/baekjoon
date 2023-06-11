import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] base = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            base[i][0] = m;
            base[i][1] = v;
        }
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        long max = max(base, bag, n, k);
        System.out.println(max);
    }

    private static long max(int[][] base, int[] bag, int n, int k) {
        Arrays.sort(base, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bag);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        int startt = 0;
        for (int i = 0; i < k; i++) {
            int max = bag[i];
            while (startt < n && base[startt][0] <= max) {
                queue.offer(base[startt][1]);
                startt++;
            }
            if (!queue.isEmpty())  result += queue.poll();
        }
//        int start = 0;
//        for (int i = 0; i < k; i++) {
//            int max = bag[i];
//            for (int j = start; j < n; j++) {
//                if (base[j][0] <= max) queue.offer(base[j][1]);
//                else {
//                    start = j;
//                    break;
//                }
//            }
//            if (!queue.isEmpty()) result += queue.poll();
//        }
        return result;
    }
}