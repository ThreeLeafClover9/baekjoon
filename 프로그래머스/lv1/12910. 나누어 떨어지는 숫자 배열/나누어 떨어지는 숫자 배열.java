import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) list.add(i);
        }
        return list.size() > 0 ? list.stream().sorted().mapToInt(i -> i).toArray() : new int[]{-1};
    }
}