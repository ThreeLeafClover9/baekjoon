import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        if (num < 100) System.out.println(num);
        else {
            int count = 99;
            for (int i = 99; i <= num; i++) {
                int a = i % 10;
                int b = i / 10 % 10;
                int c = i / 100;
                if (a - b == b - c) count++;
            }
            System.out.println(count);
        }
    }
}