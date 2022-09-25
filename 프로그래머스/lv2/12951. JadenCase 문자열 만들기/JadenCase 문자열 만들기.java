class Solution {
    public String solution(String s) {
        s += "a";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str.length() == 0) continue;
            String add = "";
            add += String.valueOf(str.charAt(0)).toUpperCase();
            add += str.substring(1, str.length()).toLowerCase();
            split[i] = add;
        }
        String join = String.join(" ", split);
        return join.substring(0, join.length() - 1);
    }
}