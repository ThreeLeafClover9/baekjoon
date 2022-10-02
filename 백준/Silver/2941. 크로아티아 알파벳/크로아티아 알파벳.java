import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        String[] split = br.readLine().split("");
        num += split.length;
        String a = "";
        String b = "";
        for (String s : split) {
            if (s.equals("=") && b.equals("z") && a.equals("d")) num -= 2;
            else if (s.equals("=")) num--;
            else if (s.equals("-")) num--;
            else if (s.equals("j") && (b.equals("l") || b.equals("n"))) num--;
            a = b;
            b = s;
        }
        System.out.println(num);
    }
}