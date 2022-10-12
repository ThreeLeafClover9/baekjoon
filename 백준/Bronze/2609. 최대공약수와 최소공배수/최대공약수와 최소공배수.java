import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) listA.add(i);
        }
        List<Integer> listB = new ArrayList<>();
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) listB.add(i);
        }

        int min = 1;
        for (Integer integer : listA) {
            if (listB.contains(integer)) min = integer;
        }

        int max = min * a / min * b / min;
        bw.write(min + "\n");
        bw.write(max + "\n");
        bw.close();
    }
}