class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int divisor = 0;
            if (n % i == 0) divisor = i;
            answer += divisor;
        }        
        
        return answer;
    }
}