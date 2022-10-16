import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int size = 1;
        int index = k;
        bw.write("<");
        while (true) {
            Integer integer = list.get(index - 1);
            list.remove(index - 1);
            bw.write(integer + "");
            index += k - 1;
            size = list.size();
            if (size == 0) break;
            bw.write(", ");
            while (index > size) index -= size;
        }
        bw.write(">");
        bw.close();
    }
}