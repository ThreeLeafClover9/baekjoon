class Solution {
    public int solution(int n) {
        int index = 1;
        while (true) {
            if (n % index == 1) return index;
            index++;
        }
    }
}