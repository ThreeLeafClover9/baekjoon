import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            String format = String.format("%d * %d = %d\n", num, i, num * i);
            bw.write(format);
        }
        bw.close();
    }
}