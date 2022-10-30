import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < first; i++) {
            String s = br.readLine();
            set.add(s);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < last; i++) {
            String s = br.readLine();
            if (set.contains(s)) result.add(s);
        }
        sb.append(result.size() + "\n");
        Collections.sort(result);
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}