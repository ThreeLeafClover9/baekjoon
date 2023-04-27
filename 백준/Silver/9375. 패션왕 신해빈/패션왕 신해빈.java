import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                if (map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 1);
            }
            int passion = passion(map);
            sb.append(passion).append("\n");
        }
        System.out.println(sb);
    }

    private static int passion(Map<String, Integer> map) {
        int num = 1;
        Set<String> strings = map.keySet();
        for (String string : strings) {
            Integer integer = map.get(string);
            num *= integer + 1;
        }
        return num - 1;
    }
}