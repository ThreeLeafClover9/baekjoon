import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Long> base = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            base.put(num, 0L);
        }
        divide(base);
        StringBuilder sb = new StringBuilder();
        for (Long value : base.values()) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }

    private static void divide(Map<Integer, Long> base) {
        for (Integer num : base.keySet()) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    if (base.containsKey(i)) {
                        base.put(num, base.get(num) - 1);
                        base.put(i, base.get(i) + 1);
                    }
                    int j = num / i;
                    if (j != i && base.containsKey(j)) {
                        base.put(num, base.get(num) - 1);
                        base.put(j, base.get(j) + 1);
                    }
                }
            }
        }
    }
}