import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 1;
        int tmp = 2;
        while (tmp <= num) {
            tmp += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}