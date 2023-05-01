import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split(" ");
        }
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            findPath(i, matrix, queue, new boolean[N], N);
        }
        for (String[] strings : matrix) {
            String join = String.join(" ", strings);
            System.out.println(join);
        }
    }

    private static void findPath(int start, String[][] matrix, Queue<Integer> queue, boolean[] check, int N) {
        boolean first = false;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (first) matrix[start][poll] = "1";
            first = true;
            for (int i = 0; i < N; i++) {
                if (matrix[poll][i].equals("1") && !check[i]) {
                    check[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}