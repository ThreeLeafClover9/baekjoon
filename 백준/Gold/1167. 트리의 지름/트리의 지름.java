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
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            while (!s.equals("-1")) {
                int end = Integer.parseInt(s);
                int value = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                listArr[start].add(new int[]{end, value});
            }
        }
        int[] result = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        check[1] = true;
        diameter(1, 0, listArr, check, result);
        int index = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int num = result[i];
            if (num > max) {
                max = num;
                index = i;
            }
        }
        result = new int[N + 1];
        check = new boolean[N + 1];
        check[index] = true;
        diameter(index, 0, listArr, check, result);
        max = 0;
        for (int num : result) {
            if (num > max)  max = num;
        }
        System.out.println(max);
    }

    private static void diameter(int start, int value, List<int[]>[] listArr, boolean[] check, int[] result) {
        for (int[] arr : listArr[start]) {
            int end = arr[0];
            if (!check[end]) {
                int newValue = arr[1] + value;
                if (result[end] < newValue) {
                    result[end] = newValue;
                    check[end] = true;
                    diameter(end, newValue, listArr, check, result);
                    check[end] = false;
                }
            }
        }
    }
}