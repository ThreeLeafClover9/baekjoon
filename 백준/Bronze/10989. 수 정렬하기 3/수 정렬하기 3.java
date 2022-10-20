import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        int[] array = new int[next];
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
        }
        Arrays.sort(array);
        for (int i : array) {
            bw.write(i + "\n");
        }
        bw.close();
    }
}