import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = new String[26];
        for (int i = 0; i < 26; i++) {
            strings[i] = "-1";
        }

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (strings[index].equals("-1")) strings[index] = i + "";
        }
        
        String join = String.join(" ", strings);
        System.out.println(join);
    }
}