import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] base = new int[N];
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        int partialSequence = partialSequence(N, base);
        System.out.println(partialSequence);
    }

    private static int partialSequence(int N, int[] base) {
        int resultNum = 1;
        int[] result = new int[N + 1];
        result[1] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (base[i] > base[j]) {
                    resultNum = Math.max(resultNum, result[i + 1] = Math.max(result[i + 1], result[j + 1] + 1));
                } else result[i + 1] = Math.max(result[i + 1], 1);
            }
        }
        return resultNum;
    }
}
