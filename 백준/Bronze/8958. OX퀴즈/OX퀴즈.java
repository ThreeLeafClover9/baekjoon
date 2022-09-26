import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            int sum = 0;
            int add = 0;
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                String str = split[j];
                if (str.equals("O")) {
                    add++;
                    sum += add;
                } else add = 0;
            }
            bw.write(sum + "\n");
        }
        bw.close();
    }
}