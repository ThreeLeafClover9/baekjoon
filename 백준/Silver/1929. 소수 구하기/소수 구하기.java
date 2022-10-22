import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 2; i <= end; i++) {
            int num = i;
            while (num <= end) {
                num += i;
                if (num <= end) set.add(num);
            }
        }
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) bw.write(i + "\n");
        }
        bw.close();
    }
}