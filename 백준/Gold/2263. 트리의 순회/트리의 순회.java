import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        tour(0, N - 1, 0, N - 1, str1, str2, sb);
        System.out.println(sb);
    }

    private static void tour(int leftStart, int leftEnd, int rightStart, int rightEnd, String[] str1, String[] str2, StringBuilder sb) {
        if (leftStart > leftEnd) return;
        if (leftStart == leftEnd) {
            sb.append(str1[leftStart]).append(" ");
            return;
        }
        String s = str2[rightEnd];
        sb.append(s).append(" ");
        int size = -1;
        for (int i = leftStart; i <= leftEnd; i++) {
            size++;
            if (str1[i].equals(s)) {
                tour(leftStart, i - 1, rightStart, rightStart + size - 1, str1, str2, sb);
                tour(i + 1, leftEnd, rightStart + size, rightEnd - 1, str1, str2, sb);
                return;
            }
        }
    }
}