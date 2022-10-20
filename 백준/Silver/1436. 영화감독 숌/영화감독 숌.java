import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 0;
        while (count != num) {
            result++;
            if ((result + "").contains("666")) count++;
        }
        System.out.println(result);
    }
}