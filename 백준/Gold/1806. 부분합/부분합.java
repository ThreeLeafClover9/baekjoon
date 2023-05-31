import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[N + 1];
        int[] index = new int[N + 1];
        int part = part(arr, N, S, result, index);
        System.out.println(part);
    }

    private static int part(int[] arr, int N, int S, int[] result, int[] index) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int num = result[i - 1] + arr[i];
            result[i] = num;
            index[i] = index[i - 1];
            if (num >= S) {
                for (int j = index[i]; j <= i - 1; j++) {
                    num -= arr[j];
                    if (num >= S) {
                        index[i] = j + 1;
                        result[i] = num;
                    } else break;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (index[i] == 0) continue;
            int num = i - index[i];
            min = Math.min(min, num);
        }
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
}