class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String str = "*".repeat(len - 4);
        return str += String.copyValueOf(phone_number.toCharArray(), len - 4, 4);
    }
}