import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        nAndM(1, N, M, list, new int[M], 0);
        for (int[] ints : list) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void nAndM(int start, int N, int M, List<int[]> list, int[] arr, int index) {
        if (index == M) {
            list.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[index] = i;
            nAndM(i, N, M, list, arr, index + 1);
        }
    }
}
