import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(br.readLine());
        }
        int result = 64;
        for (int k = 0; k <= y - 8; k++) {
            for (int i = 0; i <= x - 8; i++) {
                int b = 0;
                int w = 0;
                for (int j = 0; j < 8; j++) {
                    String substring = list.get(i + j).substring(k, k + 8);
                    b += countB(substring, j);
                    w += countW(substring, j);
                }
                result = Math.min(result, Math.min(b, w));
            }
        }
        System.out.println(result);
    }

    static int countB(String str, int j) {
        String b = "BWBWBWBW";
        String w = "WBWBWBWB";
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (j % 2 == 0) {
                if (str.charAt(i) != b.charAt(i)) count++;
            } else {
                if (str.charAt(i) != w.charAt(i)) count++;
            }
        }
        return count;
    }

    static int countW(String str, int j) {
        String b = "BWBWBWBW";
        String w = "WBWBWBWB";
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (j % 2 == 0) {
                if (str.charAt(i) != w.charAt(i)) count++;
            } else {
                if (str.charAt(i) != b.charAt(i)) count++;
            }
        }
        return count;
    }
}