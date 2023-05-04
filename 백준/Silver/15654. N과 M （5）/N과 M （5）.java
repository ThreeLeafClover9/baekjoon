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
        st = new StringTokenizer(br.readLine());
        int[] base = new int[N];
        boolean[] check = new boolean[N];
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(base);
        List<int[]> list = new ArrayList<>();
        nAndM(N, M, list, new int[M], 0, base, check);
        for (int[] ints : list) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void nAndM(int N, int M, List<int[]> list, int[] arr, int index, int[] base, boolean[] check) {
        if (index == M) {
            list.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            check[i] = true;
            arr[index] = base[i];
            nAndM(N, M, list, arr, index + 1, base, check);
            check[i] = false;
        }
    }
}
