import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int squares = squares(N);
        System.out.println(squares);
    }

    private static int squares(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = arr[i - 1];
            for (int j = 2; j * j <= i; j++) {
                int tmp = arr[i - j * j];
                num = Math.min(num, tmp);
            }
            arr[i] = num + 1;
        }
        return arr[n];
    }
}