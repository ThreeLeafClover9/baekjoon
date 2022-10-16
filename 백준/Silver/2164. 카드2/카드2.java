import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            deque.add(i);
        }
        while (deque.size() != 1) {
            deque.pollFirst();
            deque.add(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }
}