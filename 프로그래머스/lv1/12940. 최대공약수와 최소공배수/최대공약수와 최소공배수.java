class Solution {
    public int[] solution(int n, int m) {
        int divisor = 1;
        for (int i = 2; i <= n && i <= m; i++) {
            if (n % i == 0 && m % i == 0) divisor = i;
        }
        int multiple = n * m / divisor;
        return new int[]{divisor, multiple};
    }
}