import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int next = Integer.parseInt(br.readLine());
        for (int i = 1; i <= next; i++) {
            String str = " ".repeat(next - i);
            str += "*".repeat(i);
            bw.write(str + "\n");
        }
        bw.close();
    }
}