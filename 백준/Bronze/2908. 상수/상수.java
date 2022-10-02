import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        String[] split = br.readLine().split(" ");
        for (String s : split) {
            String str = "";
            for (int j = 0; j < s.length(); j++) {
                str += s.charAt(s.length() - 1 - j);
            }
            if (Integer.valueOf(str) > num) num = Integer.valueOf(str);
        }
        System.out.println(num);
    }
}