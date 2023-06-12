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
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        int part = part(base, result, n);
        System.out.println(part);
    }

    private static int part(int[] base, int[] result, int n) {
        for (int i = 0; i < n; i++) {
            int num = base[i];
            find(result, num, 0, n);
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (result[i] != Integer.MAX_VALUE) max = i;
        }
        return max;
    }

    private static void find(int[] result, int num, int start, int end) {
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (num <= result[mid]) end = mid;
            else start = mid;
        }
        result[start + 1] = num;
    }
}