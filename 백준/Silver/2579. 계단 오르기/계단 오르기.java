import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int num = stairs(arr, N);
        System.out.println(num);
    }

    private static int stairs(int[] arr, int len) {
        int[] one = new int[len + 1];
        int[] two = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int num = arr[i - 1];
            if (i == 1) {
                one[i] = num;
            } else if (i == 2) {
                one[i] = one[i - 1] + num;
                two[i] = num;
            } else {
                one[i] = Math.max(two[i - 1], one[i - 2]) + num;
                two[i] = Math.max(two[i - 2], one[i - 2]) + num;
            }
        }
        return Math.max(one[len], two[len]);
    }
}