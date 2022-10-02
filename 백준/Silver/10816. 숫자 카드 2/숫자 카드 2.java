import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (map.containsKey(s)) {
                Integer integer = map.get(s);
                map.put(s, ++integer);
            } else map.put(s, 1);
        }
        next = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        split = br.readLine().split(" ");
        for (String s : split) {
            if (map.containsKey(s)) list.add(String.valueOf(map.get(s)));
            else list.add("0");
        }
        String join = String.join(" ", list);
        System.out.println(join);
    }
}