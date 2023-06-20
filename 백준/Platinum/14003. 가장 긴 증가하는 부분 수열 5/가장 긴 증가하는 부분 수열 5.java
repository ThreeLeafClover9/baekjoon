import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] base = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        String part = part(base, list, n);
        System.out.println(part);
    }

    private static String part(int[] base, List<int[]>[] list, int n) {
        for (int i = 0; i < n; i++) {
            find(list, base[i], 0, n - 1, i);
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (list[i].size() != 0) len = i + 1;
            else break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        String part = findPart(list, len);
        sb.append(part);
        return sb.toString();
    }

    private static void find(List<int[]>[] list, int num, int start, int end, int index) {
        while (start < end) {
            int mid = (start + end) / 2;
            List<int[]> arr = list[mid];
            int size = arr.size();
            if (size != 0) {
                if (num <= arr.get(size - 1)[0]) end = mid;
                else start = mid + 1;
            } else end = mid;
        }
        if (list[start].size() == 0) {
            list[start].add(new int[]{num, index});
        }
        else if (list[start].get(list[start].size() - 1)[0] != num) list[start].add(new int[]{num, index});
    }

    private static String findPart(List<int[]>[] lists, int n) {
        Stack<int[]> stack = new Stack<>();
        int i = n - 1;
        while (stack.size() < n && i >= 0) {
            List<int[]> list = lists[i];
            for (int j = list.size() - 1; j >= 0; j--) {
                int[] arr = list.get(j);
                if (stack.size() == 0) stack.push(arr);
                else if (arr[1] < stack.peek()[1] && arr[0] < stack.peek()[0]) {
                    stack.push(arr);
                    break;
                }
            }
            i--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()[0]).append(" ");
        }
        return sb.toString();
    }
}