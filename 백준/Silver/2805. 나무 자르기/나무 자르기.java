import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int next = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(str);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
        long left = 0;
        long right = list.get(0);
        long mid = 0;
        while (right - left != 1) {
            mid = (left + right) / 2;
            long count = 0;
            for (Integer listInt : list) {
                if (listInt > mid) count += listInt - mid;
            }
            if (count >= max) left = mid;
            else right = mid;
        }
        System.out.println(left);
    }
}