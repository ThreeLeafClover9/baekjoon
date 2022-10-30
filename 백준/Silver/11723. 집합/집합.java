import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            String s = st.nextToken();
            String num = "";
            if (st.hasMoreTokens()) {
                num = st.nextToken();
            }
            if (s.equals("add")) set.add(num);
            else if (s.equals("remove")) set.remove(num);
            else if (s.equals("check")) {
                if (set.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            } else if (s.equals("toggle")) {
                if (set.contains(num)) set.remove(num);
                else set.add(num);
            } else if (s.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j + "");
                }
            } else set.clear();
        }
        System.out.println(sb);
    }
}