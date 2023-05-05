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
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }
        rgbDistance(list, N);
        int[] result = list.get(N - 1);
        int min = Integer.MAX_VALUE;
        for (int i : result) {
            if (i < min) min = i;
        }
        System.out.println(min);
    }

    private static void rgbDistance(List<int[]> list, int n) {
        for (int i = 1; i < n; i++) {
            int[] before = list.get(i - 1);
            int[] current = list.get(i);
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    int beforeMin = before[k];
                    if (beforeMin < min) min = beforeMin;
                }
                current[j] += min;
            }
        }
    }
}

