import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            String s = st.nextToken();
            if (s.equals("push_front")) {
                String num = st.nextToken();
                deque.push(num);
            } else if (s.equals("push_back")) {
                String num = st.nextToken();
                deque.add(num);
            } else if (s.equals("pop_front")) {
                if (deque.size() == 0) bw.write("-1\n");
                else bw.write(deque.pop() + "\n");
            } else if (s.equals("pop_back")) {
                if (deque.size() == 0) bw.write("-1\n");
                else bw.write(deque.pollLast() + "\n");
            } else if (s.equals("size")) bw.write(deque.size() + "\n");
            else if (s.equals("empty")) {
                if (deque.size() == 0) bw.write("1\n");
                else bw.write("0\n");
            } else if (s.equals("front")) {
                if (deque.size() == 0) bw.write("-1\n");
                else bw.write(deque.peekFirst() + "\n");
            } else {
                if (deque.size() == 0) bw.write("-1\n");
                else bw.write(deque.peekLast() + "\n");
            }
        }
        bw.close();
    }
}