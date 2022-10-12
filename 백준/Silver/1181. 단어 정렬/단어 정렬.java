import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Comparator
                .comparing(String::length)
                .thenComparing(String::toString));
        for (int i = 0; i < next; i++) {
            set.add(br.readLine());
        }
        for (String s : set) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}