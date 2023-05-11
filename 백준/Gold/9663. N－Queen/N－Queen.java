import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] chess = new int[N];
        Arrays.fill(chess, 100);
        int queen = queen(chess, N, 0);
        System.out.println(queen);
    }

    private static int queen(int[] chess, int N, int depth) {
        if (N == depth) return 1;
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (check(chess, i, N, depth)) continue;
            chess[depth] = i;
            num += queen(chess, N, depth + 1);
            chess[depth] = 100;
        }
        return num;
    }

    private static boolean check(int[] chess, int index, int N, int depth) {
        for (int i = 0; i < N; i++) {
            int before = chess[i];
            if (index == before - depth + i || index == before || index == before + depth - i) return true;
        }
        return false;
    }
}