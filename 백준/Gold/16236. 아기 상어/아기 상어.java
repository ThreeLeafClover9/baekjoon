import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        StringTokenizer st;
        int row = 0;
        int col = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    row = i;
                    col = j;
                    num = 0;
                }
                if (num != 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                matrix[i][j] = num;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, 2, 0, 0});
        int[][] DIR = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] check = new boolean[N][N];
        check[row][col] = true;
        int shark = shark(queue, matrix, DIR, check, N, map);
        System.out.println(shark);
    }

    private static int shark(Queue<int[]> queue, int[][] matrix, int[][] DIR, boolean[][] check, int N, Map<Integer, Integer> map) {
        int result = 0;
        int row = N;
        int col = N;
        int size = 2;
        int count = 0;
        int distance = 0;
        while (!queue.isEmpty()) {
            boolean food = false;
            for (int[] arr : queue) {
                int newRow = arr[0];
                int newCol = arr[1];
                int newSize = arr[2];
                int newCount = arr[3];
                int newDistance = arr[4];
                int num = matrix[newRow][newCol];
                if (num != 0 && num < size) {
                    if (newRow > row) continue;
                    if (newRow == row && newCol > col) continue;
                    row = newRow;
                    col = newCol;
                    size = newSize;
                    count = newCount;
                    distance = newDistance;
                    food = true;
                }
            }
            if (food) {
                if (count + 1 == size) {
                    size++;
                    count = -1;
                }
                int num = matrix[row][col];
                map.put(num, map.get(num) - 1);
                boolean mom = true;
                for (int j = 0; j < size; j++) {
                    Integer integer = map.getOrDefault(j, 0);
                    if (integer > 0) {
                        mom = false;
                    }
                }
                if (mom) {
                    return distance;
                }
                queue.clear();
                matrix[row][col] = 0;
                queue.add(new int[]{row, col, size, count + 1, distance});
                check = new boolean[N][N];
                check[row][col] = true;
                result = distance;
            }
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] poll = queue.poll();
                row = poll[0];
                col = poll[1];
                size = poll[2];
                count = poll[3];
                distance = poll[4];
                for (int j = 0; j < 4; j++) {
                    int newRow = row + DIR[j][0];
                    int newCol = col + DIR[j][1];
                    if (check(newRow, newCol, N) && !check[newRow][newCol] && matrix[newRow][newCol] <= size) {
                        queue.add(new int[]{newRow, newCol, size, count, distance + 1});
                        check[newRow][newCol] = true;
                    }
                }
            }
            row = N;
            col = N;
        }
        return result;
    }

    private static boolean check(int newRow, int newCol, int N) {
        return newRow >= 0 && newRow < N && newCol >= 0 && newCol < N;
    }
}