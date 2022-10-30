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
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();
        for (int i = 0; i < first; i++) {
            String s = br.readLine();
            nameMap.put(s, i + 1);
            numMap.put(i + 1, s);
        }
        for (int i = 0; i < last; i++) {
            String s = br.readLine();
            if (nameMap.containsKey(s)) sb.append(nameMap.get(s) + "\n");
            else sb.append(numMap.get(Integer.parseInt(s)) + "\n");
        }
        System.out.println(sb);
    }
}