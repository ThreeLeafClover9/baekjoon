import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
//            Set<String> base = new HashSet<>();
            Map<String, Integer> base = new HashMap<>();
            Set<String> duplicate = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean check = false;
            for (int j = 0; j < N; j++) {
                String str = st.nextToken();
                int value = base.getOrDefault(str, 0) + 1;
                if (value == 3) {
                    sb.append(0).append("\n");
                    check = true;
                    break;
                }
                if (base.containsKey(str)) duplicate.add(str);
                base.put(str, value);
            }
            if (!check) {
                closest(new ArrayList<>(base.keySet()), duplicate, sb);
            }
        }
        System.out.println(sb);
    }

    private static void closest(List<String> base, Set<String> duplicate, StringBuilder sb) {
        int n = base.size();
        if (n == 2) {
            int distance = distance(base.get(0), base.get(1));
            sb.append(distance * 2).append("\n");
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int distance = 0;
                        distance += distance(base.get(i), base.get(j));
                        distance += distance(base.get(j), base.get(k));
                        distance += distance(base.get(k), base.get(i));
                        result = Math.min(result, distance);
                    }
                }
            }
            for (String str1 : duplicate) {
                for (String str2 : base) {
                    if (str1.equals(str2)) continue;
                    int distance = distance(str1, str2);
                    result = Math.min(result, distance * 2);
                }
            }
            sb.append(result).append("\n");
        }
    }

    private static int distance(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }
}