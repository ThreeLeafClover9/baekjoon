import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = max(matrix, n, 0);
        System.out.println(max);
    }

    private static int max(int[][] matrix, int n, int depth) {
        if (depth == 5) {
            int max = 0;
            for (int[] arr : matrix) {
                for (int i : arr) {
                    max = Math.max(max, i);
                }
            }
            return max;
        }
        int max = 0;
        max = Math.max(max, max(left(matrix, n), n, depth + 1));
        max = Math.max(max, max(up(matrix, n), n, depth + 1));
        max = Math.max(max, max(right(matrix, n), n, depth + 1));
        max = Math.max(max, max(down(matrix, n), n, depth + 1));
        return max;
    }

    private static int[][] left(int[][] matrix, int n) {
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) queue.add(matrix[i][j]);
            }
            int before = 0;
            int index = 0;
            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                if (before == num) {
                    newMatrix[i][index - 1] = num * 2;
                    before = 0;
                }
                else {
                    newMatrix[i][index] = num;
                    before = num;
                    index++;
                }
            }
        }
        return newMatrix;
    }

    private static int[][] up(int[][] matrix, int n) {
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] != 0) queue.add(matrix[j][i]);
            }
            int before = 0;
            int index = 0;
            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                if (before == num) {
                    newMatrix[index - 1][i] = num * 2;
                    before = 0;
                }
                else {
                    newMatrix[index][i] = num;
                    before = num;
                    index++;
                }
            }
        }
        return newMatrix;
    }

    private static int[][] right(int[][] matrix, int n) {
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) queue.add(matrix[i][j]);
            }
            int before = 0;
            int index = n - 1;
            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                if (before == num) {
                    newMatrix[i][index + 1] = num * 2;
                    before = 0;
                }
                else {
                    newMatrix[i][index] = num;
                    before = num;
                    index--;
                }
            }
        }
        return newMatrix;
    }

    private static int[][] down(int[][] matrix, int n) {
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[j][i] != 0) queue.add(matrix[j][i]);
            }
            int before = 0;
            int index = n - 1;
            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                if (before == num) {
                    newMatrix[index + 1][i] = num * 2;
                    before = 0;
                }
                else {
                    newMatrix[index][i] = num;
                    before = num;
                    index--;
                }
            }
        }
        return newMatrix;
    }
}