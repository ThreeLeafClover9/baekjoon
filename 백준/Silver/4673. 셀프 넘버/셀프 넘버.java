import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 10000; i++) {
            int num = i;
            while (num <= 10000) {
                int start = num;
                int rest = 0;
                while (start > 0) {
                    rest += start % 10;
                    start /= 10;
                }
                num += rest;
                set.add(num);
            }
        }
        for (int i = 1; i < 10000; i++) {
            if (!set.contains(i)) bw.write(i + "\n");
        }
        bw.close();
    }
}