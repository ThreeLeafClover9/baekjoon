import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        memo = new int[num + 1];
        int logic = logic(num);
        System.out.println(logic);
    }

    static int[] memo;

    static int logic(int n) {
        if (memo[n] == 0) {
            if (n <= 1) {
                memo[n] = 0;
            } else if (n <= 3) {
                memo[n] = 1;
            } else if (n % 3 == 0 && n % 2 == 0) {
                memo[n] = Math.min(Math.min(logic(n / 3), logic(n / 2)), logic(n - 1)) + 1;
            } else if (n % 3 == 0) {
                memo[n] = Math.min(logic(n / 3), logic(n - 1)) + 1;
            } else if (n % 2 == 0) {
                memo[n] = Math.min(logic(n / 2), logic(n - 1)) + 1;
            } else memo[n] = logic(n - 1) + 1;
        }
        return memo[n];
    }
}