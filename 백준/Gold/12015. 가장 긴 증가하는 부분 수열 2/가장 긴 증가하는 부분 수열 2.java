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
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        int part = part(base, result, n);
        System.out.println(part);
    }

    private static int part(int[] base, int[] result, int n) {
        for (int i = 0; i < n; i++) {
            find(result, base[i], 0, n - 1);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] != Integer.MAX_VALUE) max = i;
        }
        return max + 1;
    }

    private static void find(int[] result, int num, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (num <= result[mid]) end = mid;
            else start = mid + 1;
        }
        result[start] = num;
    }
}