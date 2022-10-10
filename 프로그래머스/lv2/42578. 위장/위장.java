import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String s = clothe[1];
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else map.put(s, 2);
        }
        int result = 1;
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            result *= value;
        }
        return result - 1;
    }
}