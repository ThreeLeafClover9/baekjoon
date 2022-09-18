import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // List<Integer> list = new ArrayList<>();
        // for (int i : arr) {
        //     if (i % divisor == 0) list.add(i);
        // }
        // return list.size() > 0 ? list.stream().sorted().mapToInt(i -> i).toArray() : new int[]{-1};
        int[] intArray = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        return intArray.length > 0 ? intArray : new int[]{-1};
    }
}