import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]>[] listArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }
        boolean[] start = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            listArr[parent].add(new int[]{child, weight});
            listArr[child].add(new int[]{parent, weight});
            start[parent] = true;
        }
        int num = 0;
        for (int i = 1; i <= N; i++) {
            if (start[i]) continue;
            boolean[] check = new boolean[N + 1];
            check[i] = true;
            num = Math.max(num, diameter(i, listArr, N, check, 0));
        }
        System.out.println(num);
    }

    private static int diameter(int start, List<int[]>[] listArr, int N, boolean[] check, int weight) {
        int num = weight;
        for (int[] arr : listArr[start]) {
            int index = arr[0];
            if (check[index]) continue;
            check[index] = true;
            num = Math.max(num, diameter(index, listArr, N, check, weight + arr[1]));
            check[index] = false;
        }
        return num;
    }
}