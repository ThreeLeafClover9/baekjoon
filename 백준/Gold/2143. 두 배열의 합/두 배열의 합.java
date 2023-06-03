import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        long count = count(T, arrN, arrM, N, M);
        System.out.println(count);
    }

    private static long count(int T, int[] arrN, int[] arrM, int N, int M) {
        long count = 0;
        Map<Long, Long> mapN = new HashMap<>();
        sub(arrN, mapN, N);
        Map<Long, Long> mapM = new HashMap<>();
        sub(arrM, mapM, M);
        for (Long n : mapN.keySet()) {
            count += mapM.getOrDefault(T - n, 0L) * mapN.get(n);
        }
        return count;
    }

    private static void sub(int[] base, Map<Long, Long> map, int N) {
        for (int i = 0; i < N; i++) {
            long num = 0;
            for (int j = i; j < N; j++) {
                num += base[j];
                map.put(num, map.getOrDefault(num, 0L) + 1);
            }
        }
    }
}

