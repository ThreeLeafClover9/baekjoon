import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            String s = st.nextToken();
            if (s.equals("push")) {
                String num = st.nextToken();
                stack.push(num);
            } else if (s.equals("pop")) {
                if (stack.size() == 0) bw.write("-1\n");
                else bw.write(stack.pop() + "\n");
            } else if (s.equals("size")) bw.write(stack.size() + "\n");
            else if (s.equals("empty")) {
                if (stack.size() == 0) bw.write("1\n");
                else bw.write("0\n");
            } else {
                if (stack.size() == 0) bw.write("-1\n");
                else bw.write(stack.peek() + "\n");
            }
        }
        bw.close();
    }
}