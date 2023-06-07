import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long min = Long.MAX_VALUE;
        long[] result = null;
        for (int i = 0; i < n; i++) {
            long[] closest = closest(arr, i);
            long sum = 0;
            for (long num : closest) {
                sum += num;
            }
            long abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                result = closest;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    private static long[] closest(long[] arr, int n) {
        long[] result = null;
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (left == n) {
                left++;
                continue;
            }
            if (right == n) {
                right--;
                continue;
            }
            long num = arr[left] + arr[right] + arr[n];
            long abs = Math.abs(num);
            if (abs < min) {
                min = abs;
                result = new long[]{arr[left], arr[right], arr[n]};
            }
            if (num < 0) left++;
            else right--;
        }
        Arrays.sort(result);
        return result;
    }
}