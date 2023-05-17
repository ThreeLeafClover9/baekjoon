import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String backwardNotation = backwardNotation(str);
        System.out.println(backwardNotation);
    }

    private static String backwardNotation(String str) {
        StringBuilder sb = new StringBuilder();
        boolean order = true;
        Queue<String> queue = new LinkedList<>();
        Stack<String> operator = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) queue.add(String.valueOf(c));
            else if (c == '+' || c == '-') {
                if (order) {
                    while (!queue.isEmpty()) sb.append(queue.poll());
                    while (!operator.isEmpty()) sb.append(operator.pop());
                    operator.add(String.valueOf(c));
                    order = true;
                } else {
                    while (!queue.isEmpty()) sb.append(queue.poll());
                    while (!operator.isEmpty()) sb.append(operator.pop());
                    operator.add(String.valueOf(c));
                    order = true;
                }
            } else {
                if (c == '*' || c == '/') {
                    while (!queue.isEmpty()) sb.append(queue.poll());
                    if (!order) sb.append(operator.pop());
                    operator.add(String.valueOf(c));
                    order = false;
                } else {
                    int count = 0;
                    StringBuilder newSb = new StringBuilder();
                    c = str.charAt(++i);
                    while (c != ')' || count != 0) {
                        if (c == '(') count++;
                        if (c == ')') count--;
                        newSb.append(c);
                        c = str.charAt(++i);
                    }
                    queue.add(backwardNotation(newSb.toString()));
//                    order = true;
                }
            }
        }
        while (!queue.isEmpty()) sb.append(queue.poll());
        while (!operator.isEmpty()) sb.append(operator.pop());
        return sb.toString();
    }
}