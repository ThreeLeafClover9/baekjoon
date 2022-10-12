import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int num = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            list.add(new AbstractMap.SimpleEntry<>(s, num));
        }
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : list) {
            bw.write(entry.getValue() + " " + entry.getKey() + "\n");
        }
        bw.close();
    }
}