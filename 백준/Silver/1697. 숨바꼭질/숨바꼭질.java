import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[100001];
        int num = logic(N, K, check);
        System.out.println(num);
    }

    private static int logic(int n, int k, boolean[] check) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        int index;
        while (true) {
            int[] poll = queue.poll();
            n = poll[0];
            index = poll[1];
            if (n == k) break;
            check[n] = true;
            index++;
            int minus = n - 1;
            int plus = n + 1;
            int dou = n * 2;
            if (range(minus) && !check[minus]) queue.add(new int[]{minus, index});
            if (range(plus) && !check[plus]) queue.add(new int[]{plus, index});
            if (range(dou) && !check[dou]) queue.add(new int[]{dou, index});
        }
        return index;
    }

    private static boolean range(int num) {
        return num >= 0 && num <= 100000;
    }
}