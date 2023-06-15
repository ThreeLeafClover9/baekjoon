import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long sumCount = sumCount(arr, n, s);
        System.out.println(sumCount);
        br.close();
    }

    private static long sumCount(long[] arr, int n, int s) {
        List<Long> leftList = new ArrayList<>();
        sum(0, n / 2, arr, leftList, 0);
        List<Long> rightList = new ArrayList<>();
        sum(n / 2, n, arr, rightList, 0);
        long count = count(leftList, rightList, s);
        return count;
    }

    private static long count(List<Long> leftList, List<Long> rightList, int s) {
        long count = 0;
        if (s == 0) count--;
        Collections.sort(leftList);
        Collections.sort(rightList);
        int left = 0;
        int right = rightList.size() - 1;
        while (left < leftList.size() && right >= 0) {
            long leftSum = leftList.get(left);
            long rightSum = rightList.get(right);
            long num = leftSum + rightSum;
            if (num == s) {
                long leftCount = 0;
                while (left < leftList.size() && leftSum == leftList.get(left)) {
                    left++;
                    leftCount++;
                }
                long rightCount = 0;
                while (right >= 0 && rightSum == rightList.get(right)) {
                    right--;
                    rightCount++;
                }
                count += leftCount * rightCount;
            } else if (num < s) {
                left++;
            } else right--;
        }
        return count;
    }

    private static void sum(int start, int end, long[] arr, List<Long> list, long sum) {
        if (start == end) {
            list.add(sum);
            return;
        }
        sum(start + 1, end, arr, list, sum + arr[start]);
        sum(start + 1, end, arr, list, sum);
    }
}