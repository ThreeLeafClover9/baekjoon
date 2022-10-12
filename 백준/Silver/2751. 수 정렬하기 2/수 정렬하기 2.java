import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);
        for (Integer integer : list) {
            bw.write(integer + "\n");
        }
        bw.close();
    }
}