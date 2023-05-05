import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int aArrowB = aArrowB(A, B);
        System.out.println(aArrowB);
    }

    private static int aArrowB(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{b, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int num = poll[0];
            int step = poll[1];
            if (num == a) return step;
            if (num % 10 == 1 && num > 10) queue.add(new int[]{num / 10, step + 1});
            if (num % 2 == 0) queue.add(new int[]{num / 2, step + 1});
        }
        return -1;
    }
}
