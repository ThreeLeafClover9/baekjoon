class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 != 0) return -1;
        else answer = (long) sqrt + 1;
        return answer * answer;
    }
}