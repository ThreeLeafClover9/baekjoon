import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int next = Integer.parseInt(br.readLine());

        for (int i = 1; i <= next; i++) {
            bw.write(" ".repeat(next - i));
            bw.write("*".repeat(i) + "\n");
        }
        bw.close();
    }
}