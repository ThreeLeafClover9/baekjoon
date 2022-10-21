import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = num / 5;
        num %= 5;
        while (num != 0) {
            if (count < 0) break;
            if (num % 3 == 0) {
                count += num / 3;
                num %= 3;
            } else {
                num += 5;
                count--;
            }
        }
        System.out.println(count);
    }
}