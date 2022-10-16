import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') stack.push(ch);
                else if (stack.size() == 0) check = false;
                else stack.pop();
            }
            if (stack.size() != 0) check = false;
            bw.write(check == true ? "YES\n" : "NO\n");
        }
        bw.close();
    }
}