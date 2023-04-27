import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tile = tile(N);
        System.out.println(tile);
    }

    private static int tile(int n) {
        int[] list = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 1) list[i] = i;
            else if (i == 2) list[i] = 3;
            else list[i] = (list[i - 1] + list[i - 2] * 2) % 10007;
        }
        return list[n];
    }
}