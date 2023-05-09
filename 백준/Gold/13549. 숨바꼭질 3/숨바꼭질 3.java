import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[100001];
        int num = hideSeek(N, K, check);
        System.out.println(num);
    }

    private static int hideSeek(int n, int k, boolean[] check) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        queue.add(new int[]{n, 0});
        int count;
        while (true) {
            int[] poll = queue.poll();
            n = poll[0];
            count = poll[1];
            if (n == k) break;
            check[n] = true;
            int minus = n - 1;
            int plus = n + 1;
            int dou = n * 2;
            if (range(minus) && !check[minus]) queue.add(new int[]{minus, count + 1});
            if (range(plus) && !check[plus]) queue.add(new int[]{plus, count + 1});
            if (range(dou) && !check[dou]) queue.add(new int[]{dou, count});
        }
        return count;
    }

    private static boolean range(int num) {
        return num >= 0 && num <= 100000;
    }
}