import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
        Set<int[]> set = new TreeSet<>(Arrays::compare);
        nAndM(N, M, set, new int[M], 0, base, check);
        for (int[] ints : set) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void nAndM(int N, int M, Set<int[]> set, int[] arr, int index, int[] base, boolean[] check) {
        if (index == M) {
            set.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            check[i] = true;
            arr[index] = base[i];
            nAndM(N, M, set, arr, index + 1, base, check);
            check[i] = false;
        }
    }
}
