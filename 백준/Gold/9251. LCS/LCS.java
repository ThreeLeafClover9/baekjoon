import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String left = br.readLine();
        String right = br.readLine();
        int[][] memo = new int[left.length()][right.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int lcs = lcs(0, 0, left, right, memo);
        System.out.println(lcs);
    }

    private static int lcs(int left, int right, String leftStr, String rightStr, int[][] memo) {
        if (left >= leftStr.length() || right >= rightStr.length()) return 0;
        if (memo[left][right] != -1) return memo[left][right];
        if (leftStr.charAt(left) == rightStr.charAt(right)) {
            return memo[left][right] = lcs(left + 1, right + 1, leftStr, rightStr, memo) + 1;
        }
        return memo[left][right] = Math.max(
                lcs(left + 1, right, leftStr, rightStr, memo),
                lcs(left, right + 1, leftStr, rightStr, memo)
        );
    }
}