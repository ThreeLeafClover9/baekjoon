import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String P = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] split = N == 0 ? new String[0] : str.substring(1, str.length() - 1).split(",");
            ac(P, split, sb);
        }
        System.out.println(sb);
    }

    private static void ac(String P, String[] split, StringBuilder sb) {
        Deque<String> deque = new ArrayDeque<>();
        Collections.addAll(deque, split);
        boolean front = true;
        for (int i = 0; i < P.length(); i++) {
            char c = P.charAt(i);
            if (c == 'R') front = !front;
            else {
                if (deque.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                } else {
                    if (front) deque.removeFirst();
                    else deque.removeLast();
                }
            }
        }
        sb.append("[");
        if (!deque.isEmpty()) {
            if (front) sb.append(String.join(",", deque.toArray(new String[0])));
            else {
                String str = "";
                Iterator<String> iterator = deque.descendingIterator();
                while (iterator.hasNext()) {
                    str += "," + iterator.next();
                }
                sb.append(str.substring(1));
            }
        }
        sb.append("]").append("\n");
    }
}