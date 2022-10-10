import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println((num % 4 == 0 && num % 100 != 0) || num % 400 == 0 ? 1 : 0);
    }
}