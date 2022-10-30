import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < next ; i++) {
            sum += list.get(i) * (next - i);
        }
        System.out.println(sum);
    }
}