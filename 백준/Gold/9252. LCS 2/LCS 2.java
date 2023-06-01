import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String left = br.readLine();
        String right = br.readLine();
        String[][] memo = new String[left.length()][right.length()];
        String lcs = lcs(0, 0, left, right, memo);
        System.out.println(lcs.length());
        System.out.println(lcs);
    }

    private static String lcs(int left, int right, String leftStr, String rightStr, String[][] memo) {
        if (left >= leftStr.length() || right >= rightStr.length()) return "";
        if (memo[left][right] != null) return memo[left][right];
        if (leftStr.charAt(left) == rightStr.charAt(right)) {
            return memo[left][right] = leftStr.charAt(left) + lcs(left + 1, right + 1, leftStr, rightStr, memo);
        }
        String lcsLeft = lcs(left, right + 1, leftStr, rightStr, memo);
        String lcsRight = lcs(left + 1, right, leftStr, rightStr, memo);
        return memo[left][right] = lcsLeft.length() > lcsRight.length() ? lcsLeft : lcsRight;
    }
}