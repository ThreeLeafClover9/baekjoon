import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxL = 0;
        int maxR = 0;
        for (int[] size : sizes) {
            Arrays.sort(size);
            if (size[0] > maxL) maxL = size[0];
            if (size[1] > maxR) maxR = size[1];
        }
        return maxL * maxR;
    }
}