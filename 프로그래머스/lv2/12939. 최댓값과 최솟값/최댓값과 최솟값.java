class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        String[] result = new String[]{split[0], split[0]};
        for (String str : split) {
            int i = Integer.parseInt(str);
            if (i < Integer.parseInt(result[0])) result[0] = str;
            if (i > Integer.parseInt(result[1])) result[1] = str;
        }
        return String.join(" ", result);
    }
}