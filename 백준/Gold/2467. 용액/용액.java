import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] closest = closest(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : closest) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] closest(int[] arr) {
        int[] result = null;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int num = arr[left] + arr[right];
            int abs = Math.abs(num);
            if (abs < min) {
                min = abs;
                result = new int[]{arr[left], arr[right]};
            }
            if (num < 0) left++;
            else right--;
        }
        return result;
    }
}