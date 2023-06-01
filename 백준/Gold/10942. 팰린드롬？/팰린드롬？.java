import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] base = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[]{S, E});
        }
        String palindrome = Palindrome(base, list);
        System.out.println(palindrome);
    }

    private static String Palindrome(int[] base, List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            int start = arr[0];
            int end = arr[1];
            if (check(base, start, end)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean check(int[] base, int start, int end) {
        while (start < end) {
            if (base[start] != base[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}