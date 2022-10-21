import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while (!(str = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[') stack.push(ch);
                else if (ch == ')') {
                    if (stack.size() == 0) check = false;
                    else if (stack.pop() != '(') check = false;
                }
                else if (ch == ']') {
                    if (stack.size() == 0) check = false;
                    else if (stack.pop() != '[') check = false;
                }
            }
            if (check == true && stack.size() == 0) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.close();
    }
}