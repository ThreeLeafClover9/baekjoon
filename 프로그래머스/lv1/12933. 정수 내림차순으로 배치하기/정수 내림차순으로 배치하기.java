import java.util.*;

class Solution {
    public long solution(long n) {
        String str = n + "";
        String[] strArray = str.split("");
        Arrays.sort(strArray, Collections.reverseOrder());
        str = String.join("", strArray);
        return Long.valueOf(str);
    }
}