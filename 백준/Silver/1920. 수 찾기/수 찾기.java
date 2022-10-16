import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < next; i++) {
            set.add(st.nextToken());
        }
        next = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < next; i++) {
            String s = st.nextToken();
            if (set.contains(s)) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.close();
    }
}