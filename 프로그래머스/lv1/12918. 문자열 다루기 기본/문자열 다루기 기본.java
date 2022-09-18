class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if (!(len == 4 || len == 6)) return false;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }
}