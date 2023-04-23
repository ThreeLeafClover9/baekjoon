import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        boolean[] check = new boolean[100000 + 1];
        int num =  logic(N, K, 0, check);
        System.out.println(num);
    }

    private static int logic(int n, int k, int count, boolean[] check) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        queue.add(-1);
        int index = 0;
        while (n != k) {
            n = queue.poll();
            check[n] = true;
            index = queue.poll();
            index++;
            int minus = n - 1;
            int plus = n + 1;
            int dou = n * 2;
            if (minus >= 0 && !check[minus]) {
                queue.add(minus);
                queue.add(index);
            }
            if (plus <= 100000 && !check[plus]) {
                queue.add(plus);
                queue.add(index);
            }
            if (dou <= 100000 && !check[dou]) {
                queue.add(dou);
                queue.add(index);
            }
        }
        return index;
    }
}