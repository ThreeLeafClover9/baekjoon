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
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            String result = "";
            if (n % h == 0) result += h;
            else result += n % h;
            if ((n - 1) / h + 1 < 10) result += 0;
            result += (n - 1) / h + 1;
            bw.write(result + "\n");
        }
        bw.close();
    }
}