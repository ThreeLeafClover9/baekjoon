class Solution {
    public int[] solution(String s) {
        int count = 0;
        int countZero = 0;
        while (!s.equals("1")) {
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') countZero++;
                else len++;
            }
            s = Integer.toBinaryString(len);
            count++;
        }
        return new int[]{count, countZero};
    }
}