import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int next = Integer.parseInt(br.readLine());
        String str = br.readLine();
        st = new StringTokenizer(str);
        int min = Integer.parseInt(st.nextToken()), max = min;
        for (int i = 1; i < next; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        System.out.println(min + " " + max);
    }
}