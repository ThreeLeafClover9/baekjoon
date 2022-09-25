import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        while (i < completion.length) {
            if (!participant[i].equals(completion[i])) return participant[i];
            i++;
        }
        return participant[i];
    }
}