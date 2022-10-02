import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int next = Integer.parseInt(split[0]);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < next; i++) {
            set.add(br.readLine());
        }
        int count = 0;
        next = Integer.parseInt(split[1]);
        for (int i = 0; i < next; i++) {
            if (set.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}