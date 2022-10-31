import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(br.readLine());
            memo = new int[num + 1];
            int fir = fibonacci(num);
            int sec = fibonacci(num - 1);
            sb.append(sec + " " + fir + "\n");
        }
        System.out.println(sb);
    }

    static int[] memo;

    static int fibonacci(int n) {
        if (n < 0) {
            return 1;
        }
        if (n <= 1) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        } else return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}