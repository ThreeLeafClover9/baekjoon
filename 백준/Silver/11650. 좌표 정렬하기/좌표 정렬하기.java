import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        SortedSet<KeyValuePair> sortedSet = new TreeSet<>();
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sortedSet.add(new KeyValuePair(a, b));
        }
        for (KeyValuePair keyValuePair : sortedSet) {
            bw.write(keyValuePair.key + " " + keyValuePair.value + "\n");
        }
        bw.close();
    }
    
    static class KeyValuePair implements Comparable<KeyValuePair>{
        int key, value;

        public KeyValuePair(int key, int value) {
            super();
            this.key = key;
            this.value = value;
        }

        public int compareTo(KeyValuePair o) {
            return key==o.key?value-o.value:key-o.key;
        }
    }
}