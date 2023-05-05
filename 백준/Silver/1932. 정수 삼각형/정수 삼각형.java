import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }
        triangle(list, N);
        int max = Integer.MIN_VALUE;
        for (int anInt : list.get(N - 1)) {
            max = Math.max(max, anInt);
        }
        System.out.println(max);
    }

    private static void triangle(List<int[]> list, int n) {
        for (int i = 1; i < n; i++) {
            int[] before = list.get(i - 1);
            int[] current = list.get(i);
            for (int j = 0; j <= i; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = j - 1; k <= j; k++) {
                    if (k < 0 || k == i) continue;
                    int num = before[k];
                    if (num > max) max = num;
                }
                current[j] += max;
            }
        }
    }
}

