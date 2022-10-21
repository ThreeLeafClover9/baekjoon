import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[next][2];
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for (int[] ints : arr) {
            for (int i : ints) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}