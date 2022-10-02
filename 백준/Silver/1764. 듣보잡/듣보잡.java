import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int next = Integer.parseInt(split[0]);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < next; i++) {
            set.add(br.readLine());
        }
        next = Integer.parseInt(split[1]);
        Set<String> result = new TreeSet<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            if (set.contains(str)) result.add(str);
        }
        bw.write(result.size() + "\n");
        for (String s : result) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}