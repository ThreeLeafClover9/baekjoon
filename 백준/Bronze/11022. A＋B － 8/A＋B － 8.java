import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int next = Integer.parseInt(br.readLine());
        for (int i = 1; i <= next; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String format = String.format("Case #%d: %d + %d = %d\n", i, a, b, a + b);
            bw.write(format);
        }
        bw.close();
    }
}