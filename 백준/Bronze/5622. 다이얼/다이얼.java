import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'P' && str.charAt(i) <= 'S') num += 8;
            else if (str.charAt(i) >= 'T' && str.charAt(i) <= 'V') num += 9;
            else if (str.charAt(i) >= 'W' && str.charAt(i) <= 'Z') num += 10;
            else num += (str.charAt(i) - '8') / 3;
        }
        System.out.println(num);
    }
}