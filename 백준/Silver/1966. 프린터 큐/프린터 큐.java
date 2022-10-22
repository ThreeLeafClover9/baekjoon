import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int length = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            str = br.readLine();
            st = new StringTokenizer(str);
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(new int[]{num, j});
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean check = true;
                for (int[] ints : queue) {
                    if (ints[0] > poll[0]) {
                        queue.add(poll);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                    if (poll[1] == index) {
                        bw.write(count + "\n");
                    }
                }
            }
        }
        bw.close();
    }
}