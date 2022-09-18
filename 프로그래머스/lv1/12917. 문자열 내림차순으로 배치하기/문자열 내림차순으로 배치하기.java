import java.util.*;

class Solution {
    public String solution(String s) {
        String[] split = s.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        return String.join("", split);
    }
}