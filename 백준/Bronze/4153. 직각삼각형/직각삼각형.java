import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        StringTokenizer st;
        while (!(str = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(str);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if (a * a + b * b == c * c) bw.write("right\n");
            else bw.write("wrong\n");
        }
        bw.close();
    }
}