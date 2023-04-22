import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int next = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < next; i++) {
            logic(Long.parseLong(br.readLine()), queue, sb);
        }
        System.out.println(sb);
    }

    private static void logic(long num, PriorityQueue<Long> queue, StringBuilder sb) {
        if (num == 0) {
            if (queue.isEmpty()) sb.append(0).append("\n");
            else sb.append(queue.poll()).append("\n");
        } else queue.add(num);
    }
}