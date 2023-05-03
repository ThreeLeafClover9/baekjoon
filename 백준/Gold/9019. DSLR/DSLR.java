import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            String[] result = new String[10000];
            Arrays.fill(result, "");
            sb.append(DSLR(start, end, new boolean[10000], result)).append("\n");
        }
        System.out.println(sb);
    }

    private static String DSLR(int start, int end, boolean[] check, String[] result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num == end) return result[num];
            int numD = (num * 2) % 10000;
            if (!check[numD]) {
                queue.add(numD);
                result[numD] = result[num] + "D";
                check[numD] = true;
            }
            int numS = num == 0 ? 9999 : num - 1;
            if (!check[numS]) {
                queue.add(numS);
                result[numS] = result[num] + "S";
                check[numS] = true;
            }
            int numL = (num % 1000) * 10 + num / 1000;
            if (!check[numL]) {
                queue.add(numL);
                result[numL] = result[num] + "L";
                check[numL] = true;
            }
            int numR = (num % 10) * 1000 + num / 10;
            if (!check[numR]) {
                queue.add(numR);
                result[numR] = result[num] + "R";
                check[numR] = true;
            }
        }
        return null;
    }
}