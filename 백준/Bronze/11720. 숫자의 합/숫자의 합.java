import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("");
        int sum = 0;
        for (String s : split) {
            int num = Integer.parseInt(s);
            sum += num;
        }
        System.out.println(sum);
    }
}