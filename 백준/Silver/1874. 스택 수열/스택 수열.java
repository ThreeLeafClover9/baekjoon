import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int next = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
            list.add(num);
        }
        Collections.sort(list);
        int dif = 0;
        if (next >= 2) {
            dif = list.get(0) - list.get(1);
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int num = list.get(i) - list.get(i + 1);
            if (num != dif) {
                sb.append("NO\n");
                queue.clear();
                break;
            }
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        while (!queue.isEmpty()) {
            if (stack.isEmpty()) {
                num++;
                stack.push(num);
                sb.append("+\n");
            }
            int queuePeek = queue.peek();
            int stackPeek = stack.peek();
            if (queuePeek > stackPeek) {
                num++;
                stack.push(num);
                sb.append("+\n");
            } else if (queuePeek == stackPeek) {
                stack.pop();
                queue.poll();
                sb.append("-\n");
            } else {
                if (!stack.contains(queuePeek)) {
                    sb = new StringBuilder();
                    sb.append("NO\n");
                    break;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}