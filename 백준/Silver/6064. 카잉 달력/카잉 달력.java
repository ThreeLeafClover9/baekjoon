import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(kaingCalendar(M, N, x, y)).append("\n");
        }
        System.out.println(sb);
    }

    private static int kaingCalendar(int M, int N, int x, int y) {
        int result = y;
        int first = M >= y ? y : (y % M == 0 ? M : y % M);
        if (first == x) return result;
        while (result <= M * N) {
            result += N;
            first = first + N > M ? (first + N) % M == 0 ? M : (first + N) % M : first + N;
            if (first == x) return result;
        }
        return -1;
    }
}