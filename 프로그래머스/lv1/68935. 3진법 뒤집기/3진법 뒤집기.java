class Solution {
    public int solution(int n) {
        String str = "";
        while (n > 0) {
            str += n % 3;
            n /= 3;
        }
        for (int i = 0, j = 1; i < str.length(); i++) {
            int in = str.charAt(str.length() - 1 - i) - '0';
            n += in * j;
            j *= 3;
        }
        return n;
    }
}