class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String str = "*".repeat(len - 4);
        return str += phone_number.substring(len - 4, len);
    }
}