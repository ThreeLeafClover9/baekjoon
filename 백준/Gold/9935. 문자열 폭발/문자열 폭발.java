import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        String bomb = br.readLine();
        String explosion = explosion(base, bomb);
        System.out.println(explosion.length() == 0 ? "FRULA" : explosion);
    }

    private static String explosion(String base, String bomb) {
        int listIndex = bomb.length() - 1;
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            if (c == bomb.charAt(listIndex)) {
                String str = String.valueOf(c);
                for (int j = listIndex - 1; j >= 0; j--) {
                    if (deque.isEmpty()) {
                        deque.add(str);
                        break;
                    }
                    String pop = deque.pollLast();
                    if (pop.equals(String.valueOf(bomb.charAt(j)))) {
                        str = pop + str;
                    } else {
                        deque.add(pop + str);
                        break;
                    }
                }
            } else {
                deque.add(String.valueOf(c));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.poll());
        }
        return result.toString();
    }
}