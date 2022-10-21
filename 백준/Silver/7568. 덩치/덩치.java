import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[next][3];
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        for (int[] a : arr) {
            int rank = 1;
            for (int[] b : arr) {
                if (a[0] < b[0] && a[1] < b[1]) rank++;
            }
            bw.write(rank + "\n");
        }
        bw.close();
    }
}