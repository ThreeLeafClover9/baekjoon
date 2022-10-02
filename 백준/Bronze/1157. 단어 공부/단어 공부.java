import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();

        String str = br.readLine().toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                Integer integer = map.get(ch);
                integer++;
                map.put(ch, integer);
            } else map.put(ch, 1);
        }
        int before = 0;
        int max = 0;
        char ch = ' ';
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value >= max) {
                before = max;
                max = value;
                ch = characterIntegerEntry.getKey();
            }
        }
        if (before == max) ch = '?';
        System.out.println(ch);
    }
}