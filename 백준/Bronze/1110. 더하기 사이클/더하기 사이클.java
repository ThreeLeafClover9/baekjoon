import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int last = num;
        int count = 0;
        do {
            int a = last % 10;
            int b = (last / 10 + last % 10) % 10;
            last = a * 10 + b;
            count++;
        }
        while (num != last);
        System.out.println(count);
    }
}