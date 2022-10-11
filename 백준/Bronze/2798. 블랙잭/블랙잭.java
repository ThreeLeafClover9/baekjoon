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
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        for (int i = 0; i < next - 2; i++) {
            for (int j = i + 1; j < next - 1; j++) {
                for (int k = j + 1; k < next; k++) {
                    int num = list.get(i) + list.get(j) + list.get(k);
                    if (num > sum && num <= max) sum = num;
                }
            }
        }
        System.out.println(sum);
    }
}