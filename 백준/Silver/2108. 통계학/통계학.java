import java.io.*;
import java.net.CookieHandler;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        int min = 4000;
        int max = -4000;
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        Collections.sort(list);
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                result = new ArrayList<>();
                result.add(entry.getKey());
            }
            else if (entry.getValue() == count) result.add(entry.getKey());
        }
        Collections.sort(result);
        int resultNum = 0;
        resultNum = result.size() == 1 ? result.get(0) : result.get(1);
        bw.write(Math.round(sum / next) + "\n");
        bw.write(list.get(next / 2) + "\n");
        bw.write(resultNum + "\n");
        bw.write(max - min + "");
        bw.close();
    }
}