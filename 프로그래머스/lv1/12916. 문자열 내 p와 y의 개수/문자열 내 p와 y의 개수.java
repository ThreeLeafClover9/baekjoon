class Solution {
    boolean solution(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'p') count++;
            else if (ch == 'y') count--;
        }
        return count == 0 ? true : false;
    }
}