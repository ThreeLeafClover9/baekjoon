import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operator = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                logic(map, operator, num);
            }
            if (map.size() > 0) sb.append(map.lastKey()).append(" ").append(map.firstKey());
            else sb.append("EMPTY");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void logic(TreeMap<Integer, Integer> map, String operator, int num) {
        if (operator.equals("I")) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        } else {
            if (map.size() > 0) {
                int key = num == 1 ? map.lastKey() : map.firstKey();
                int value = map.get(key);
                if (value > 1) map.put(key, value - 1);
                else map.remove(key);
            }
        }
    }
}