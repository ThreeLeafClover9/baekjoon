import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) map.put(num, map.get(num) + 1);
                else map.put(num, 1);
                list.add(num);
            }
        }
        Collections.sort(list);
        int min = list.get(0);
        int max = list.get(list.size() - 1);
        int time = 1000000000;
        int height = 0;
        Outer:
        for (int integer = min; integer <= max; integer++) {
            int count = 0;
            int back = b;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (integer < key) {
                    count += (key - integer) * value * 2;
                    back += (key - integer) * value;
                } else if (integer > key) {
                    count += (integer - key) * value;
                    back -= (integer - key) * value;
                }
            }
            if (back >= 0 && count <= time) {
                time = count;
                height = integer;
            }
        }
        System.out.println(time + " " + height);
    }
}