import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        for (int i = 0; i < N; i++) {
            absoluteHeap(Integer.parseInt(br.readLine()), queue, sb);
        }
        System.out.println(sb);
    }

    private static void absoluteHeap(int num, PriorityQueue<int[]> queue, StringBuilder sb) {
        if (num == 0) {
            if (queue.isEmpty()) {
                sb.append(0);
            } else {
                int[] poll = queue.poll();
                if (poll[1] < 0) sb.append(-poll[0]);
                else sb.append(poll[0]);
            }
            sb.append("\n");
        } else if (num < 0) {
            queue.add(new int[]{-num, -1});
        } else queue.add(new int[]{num, 1});
    }
}