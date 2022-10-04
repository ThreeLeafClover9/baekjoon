import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int nextA = Integer.parseInt(split[0]);
        int nextB = Integer.parseInt(split[1]);
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        split = br.readLine().split(" ");
        for (String s : split) {
            setA.add(s);
        }
        split = br.readLine().split(" ");
        for (String s : split) {
            setB.add(s);
        }
        int countA = 0;
        int countB = 0;
        for (String s : setB) {
            if (!setA.contains(s)) countA++;
        }
        for (String s : setA) {
            if ((!setB.contains(s))) countB++;
        }
        System.out.println(countA + countB);
    }
}