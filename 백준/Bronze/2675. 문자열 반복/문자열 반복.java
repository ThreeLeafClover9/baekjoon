import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int repeat = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                String ch = String.valueOf(s.charAt(j));
                bw.write(ch.repeat(repeat));
            }
            bw.write("\n");
        }
        bw.close();
    }
}