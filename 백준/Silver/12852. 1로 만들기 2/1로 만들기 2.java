import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String count = count(N);
        System.out.println(count);
    }

    static String count(int N) {
        int[] result = new int[N + 1];
        int[] pre = new int[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int count = poll[1];
            if (index == 1) break;

            int newCount = count + 1;
            if (index % 3 == 0) {
                int newIndex = index / 3;
                if (result[newIndex] == 0) {
                    result[newIndex] = newCount;
                    pre[newIndex] = index;
                    queue.add(new int[]{newIndex, newCount});
                }
            }
            if (index % 2 == 0) {
                int newIndex = index / 2;
                if (result[newIndex] == 0) {
                    result[newIndex] = newCount;
                    pre[newIndex] = index;
                    queue.add(new int[]{newIndex, newCount});
                }
            }
            int newIndex = index - 1;
            if (newIndex >= 0) {
                if (result[newIndex] ==0) {
                    result[newIndex] = newCount;
                    pre[newIndex] = index;
                    queue.add(new int[]{newIndex, newCount});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result[1]).append("\n");
        Stack<Integer> stack = new Stack<>();
        int start = 1;
        while (start != N) {
            stack.push(start);
            start = pre[start];
        }
        stack.push(start);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }
}