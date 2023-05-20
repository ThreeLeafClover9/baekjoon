import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> house = new ArrayList<>();
        List<int[]> restaurant = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) house.add(new int[]{i, j});
                if (num == 2) restaurant.add(new int[]{i, j});
            }
        }
        int delivery = delivery(house, restaurant, M);
        System.out.println(delivery);
    }

    private static int delivery(List<int[]> hArr, List<int[]> rArr, int M) {
        int hSize = hArr.size();
        int rSize = rArr.size();
        int[][] matrix = new int[hSize][rSize];
        for (int i = 0; i < hSize; i++) {
            int[] house = hArr.get(i);
            for (int j = 0; j < rSize; j++) {
                int[] restaurant = rArr.get(j);
                matrix[i][j] = Math.abs(house[0] - restaurant[0]) + Math.abs(house[1] - restaurant[1]);
            }
        }
        List<boolean[]> cArr = new ArrayList<>();
        combination(0, rSize, M, cArr, 0, new boolean[rSize]);
        int min = Integer.MAX_VALUE;
        for (boolean[] check : cArr) {
            min = Math.min(min, min(matrix, check));
        }
        return min;
    }

    private static int min(int[][] matrix, boolean[] check) {
        int sum = 0;
        for (int[] arr : matrix) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) min = Math.min(min, arr[i]);
            }
            sum += min;
        }
        return sum;
    }

    private static void combination(int start, int rSize, int M, List<boolean[]> cArr, int count, boolean[] check) {
        if (count == M) {
            cArr.add(Arrays.copyOf(check, rSize));
        }
        for (int i = start; i < rSize; i++) {
            check[i] = true;
            combination(i + 1, rSize, M, cArr, count + 1, check);
            check[i] = false;
        }
    }
}