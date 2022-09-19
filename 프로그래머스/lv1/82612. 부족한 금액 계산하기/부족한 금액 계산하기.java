class Solution {
    public long solution(int price, int money, int count) {
        long pow = 0;
        for (int i = 1; i <= count; i++) pow += i;
        return price*pow > money ? price*pow - money : 0;
    }
}