import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int length = Integer.parseInt(br.readLine());
            list.add(length);
            sum += length;
        }
        long left = 0;
        long right = sum + 1;
        long mid = 1;
        while (right - left > 1) {
            mid = (left + right) / 2;
            int count = 0;
            for (Integer integer : list) {
                count += integer / mid;
            }
            if (count < n) right = mid;
            else left = mid;
        }
        System.out.println(left);
    }
}