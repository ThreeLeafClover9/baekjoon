class Solution {
    public int solution(int num) {
        return solution2(num, 0);
    }
    
    public int solution2(long num, int count) {
        if (count >= 500) return -1;
        else if (num == 1) return count;
        else if (num % 2 == 0) return solution2(num / 2, count + 1);
        else return solution2(num * 3 + 1, count + 1);
    }
}