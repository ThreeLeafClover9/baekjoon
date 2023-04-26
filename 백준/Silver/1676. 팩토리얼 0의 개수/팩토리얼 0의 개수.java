import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = index(N);
        System.out.println(index);
    }

    private static int index(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 125 == 0) count += 3;
            else if (i % 25 == 0) count += 2;
            else if (i % 5 == 0) count += 1;
        }
        return count;
    }
}