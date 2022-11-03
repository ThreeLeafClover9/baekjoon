import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[com][com];
        for (int i = 0; i < pair; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] check = new boolean[com];
        check[0] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < com; i++) {
                if (arr[poll][i] == 1) {
                    arr[poll][i] = 0;
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
        int count = 0;
        for (boolean b : check) {
            if (b) count++;
        }
        System.out.println(count - 1);
    }
}