import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        int[] one = new int[N + 1];
//        int[] two = new int[N + 1];
//        int num = stairs(arr, N, 0, one, two);
        int num = stairs(arr, N);
        System.out.println(num);
    }

    private static int stairs(int[] arr, int len) {
        int[] one = new int[len + 1]; // 두발자국만
        int[] two = new int[len + 1]; // 월 오알 두 발자국 가능
        for (int i = 1; i <= len; i++) {
            int num = arr[i - 1];
            if (i == 1) {
                one[i] = num;
                two[i] = 0;
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

//    private static int stairs(int[] arr, int n, int step, int[] one, int[] two) {
//        if (step == 0 && one[n] != 0) return one[n];
//        if (step == 1 && two[n] != 0) return two[n];
//        if (n == 0) return 0;
//        if (n == 1) return arr[0];
//        int num = arr[n - 1];
//        if (n == 2) {
//            if (step < 1) return num += arr[0];
//            return num;
//        }
//        if (step < 1) {
//            return Math.max(
//                    one[n] = num + stairs(arr, n - 1, step + 1, one, two),
//                    two[n] = num + stairs(arr, n - 2, 0, one, two)
//            );
//        } else return two[n] = num += stairs(arr, n - 2, 0, one, two);
//    }
}