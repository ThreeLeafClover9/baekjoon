class Solution {
    public String solution(String s) {
        int len = s.length();
        if (len % 2 == 0) return s.substring(len/2 - 1, len/2 + 1);
        return s.charAt(len / 2) + "";
    }
}