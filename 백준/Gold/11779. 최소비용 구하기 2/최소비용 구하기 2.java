import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]>[] listArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            listArr[start].add(new int[]{end, price});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        String price = price(start, end, listArr, N);
        System.out.println(price);
    }


    private static String price(int start, int end, List<int[]>[] listArr, int N) {
        int[] result = new int[N + 1];
        int[] pre = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Arrays::compare);
        queue.add(new int[]{0, start});
        while (!queue.isEmpty()) {
            int max = result[end];
            int[] poll = queue.poll();
            int length = poll[0];
            int index = poll[1];
            if (length > max) continue;
            for (int[] arr : listArr[index]) {
                int newIndex = arr[0];
                int newLength = length + arr[1];
                if (result[newIndex] > newLength && newLength < max) {
                    result[newIndex] = newLength;
                    pre[newIndex] = index;
                    queue.add(new int[]{newLength, newIndex});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result[end]).append("\n");
        Stack<Integer> stack = new Stack<>();
        while (end != start) {
            stack.push(end);
            end = pre[end];
        }
        stack.push(start);
        int size = stack.size();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }
}