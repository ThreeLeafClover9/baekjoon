import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = n + "";
        String[] strArray = str.split("");
        Arrays.sort(strArray, Collections.reverseOrder());
        str = String.join("", strArray);
        answer = Long.valueOf(str);
        return answer;
    }
}