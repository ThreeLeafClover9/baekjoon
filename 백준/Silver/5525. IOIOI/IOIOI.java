import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int ioioi = ioioi(N, S);
        System.out.println(ioioi);
    }

    private static int ioioi(int n, String s) {
        String str = "I";
        str += "OI".repeat(n);
        int len = 2 * n + 1;
        int result = 0;
        for (int i = 0; i <= s.length() - len; i++) {
            String substring = s.substring(i, i + len);
            if (str.equals(substring)) result++;
        }
        return result;
    }
}