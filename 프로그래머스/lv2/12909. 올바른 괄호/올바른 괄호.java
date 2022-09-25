import java.util.*;

class Solution {
    boolean solution(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') list.add(ch);
            else if (list.size() == 0) return false;
            else list.remove(list.size() - 1);
        }
        return list.size() == 0 ? true : false;
    }
}