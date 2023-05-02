import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> map = new HashMap<>();
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                map.put(Integer.valueOf(st.nextToken()), false);
            }
        }
        int nearestNumber = nearestNumber(N, map);
        System.out.println(nearestNumber);
    }

    private static int nearestNumber(String N, Map<Integer, Boolean> map) {
        int n = Integer.parseInt(N);
        int result = Math.abs(n - 100);
        outer:
        for (int i = 0; i < 1000000; i++) {
            int len = i == 0 ? 1 : (int)(Math.log10(i)+1);
            String s = String.valueOf(i);
            for (int j = 0; j < len; j++) {
                int index = s.charAt(j) - '0';
                if (map.containsKey(index)) continue outer;
            }
            result = Math.min(result, Math.abs(n - i) + len);
        }
        return result;
    }
}