import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        long pow = 1;
        for (int i = 0; i < num; i++) {
            int a = str.charAt(i) - '`';
            sum = (sum + a * pow) % 1234567891;
            pow = pow * 31 % 1234567891;
        }
        System.out.println(sum);
    }
}