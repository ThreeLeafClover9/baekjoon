import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = count(arr, K);
        System.out.println(count);
    }

    private static int count(int[] arr, int k) {
        int count = 0;
        while (k > 0) {
            for (int i = arr.length - 1; i >= 0; i--) {
                int coin = arr[i];
                if (k >= coin) {
                    count += k / coin;
                    k %= coin;
                }
            }
        }
        return count;
    }
}