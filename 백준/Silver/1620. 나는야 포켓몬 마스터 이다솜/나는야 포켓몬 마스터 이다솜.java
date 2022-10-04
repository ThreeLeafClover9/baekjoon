import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int next = Integer.parseInt(split[0]);
        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> intMap = new HashMap<>();
        for (int i = 1; i <= next; i++) {
            String s = br.readLine();
            strMap.put(s, i);
            intMap.put(i, s);
        }
        next = Integer.parseInt(split[1]);
        for (int i = 0; i < next; i++) {
            String s = br.readLine();
            if (strMap.containsKey(s)) bw.write(strMap.get(s) + "\n");
            else bw.write(intMap.get(Integer.parseInt(s)) + "\n");
        }
        bw.close();
    }
}