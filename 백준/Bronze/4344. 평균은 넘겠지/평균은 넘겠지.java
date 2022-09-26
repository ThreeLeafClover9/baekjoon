import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            String[] split = br.readLine().split(" ");
            int len = Integer.parseInt(split[0]);
            double sum = 0;
            for (int j = 1; j <= len; j++) {
                sum += Integer.parseInt(split[j]);
            }
            double ave = sum / len;
            double count = 0;
            for (int j = 1; j <= len; j++) {
                int num = Integer.parseInt(split[j]);
                if (num > ave) count++;
            }
            String format = String.format("%.3f", count / len * 100);
            bw.write( format + "%\n");
        }
        bw.close();
    }
}