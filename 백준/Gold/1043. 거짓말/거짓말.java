import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int M = Integer.parseInt(st.nextToken());
        boolean[][] matrix = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truth; i++) {
            int person = Integer.parseInt(st.nextToken()) - 1;
            queue.add(person);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int party = Integer.parseInt(st.nextToken());
            for (int j = 0; j < party; j++) {
                int person = Integer.parseInt(st.nextToken()) - 1;
                matrix[person][i] = true;
            }
        }
        boolean[] PARTY = new boolean[M];
        boolean[] check = new boolean[N];
        int lie = lie(queue, matrix, check, PARTY);
        System.out.println(lie);
    }

    private static int lie(Queue<Integer> queue, boolean[][] matrix, boolean[] check, boolean[] PARTY) {
        while (!queue.isEmpty()) {
            Integer person = queue.poll();
            check[person] = true;
            for (int i = 0; i < matrix[person].length; i++) {
                boolean party = matrix[person][i];
                if (party) {
                    PARTY[i] = true;
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[j][i] && !check[j]) {
                            queue.add(j);
                        }
                    }
                }
            }
        }
        int result = 0;
        for (boolean b : PARTY) {
            if (!b) result++;
        }
        return result;
    }
}