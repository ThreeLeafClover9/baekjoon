import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean[][] check = new boolean[N][N];
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && matrix[i][j] == 1) {
                    int number = number(i, j, matrix, N, check, DIR);
                    if (number != 0) list.add(number);
                }
                else check[i][j] = true;
            }
        }
//        number(0, 0, matrix, list, N, check, DIR);
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static int number(int row, int col, int[][] matrix, int N, boolean[][] check, int[][] DIR) {
        int num = 0;
        if (matrix[row][col] == 1) {
            check[row][col] = true;
            num++;
            for (int i = 0; i < 4; i++) {
                int newRow = row + DIR[i][0];
                int newCol = col + DIR[i][1];
                if (check(newRow, newCol, N) && !check[newRow][newCol]) {
                    num += number(newRow, newCol, matrix, N, check, DIR);
                }
            }
        }
        return num;
    }

//    private static void labyrinthSearch(Queue<int[]> queue, int[][] matrix, int[][] DIR, int N, int M, boolean[][] check) {
//        while (!queue.isEmpty()) {
//            int[] poll = queue.poll();
//            int row = poll[0];
//            int col = poll[1];
//            int num = poll[2];
//            if (matrix[row][col] == 1) matrix[row][col] = num;
//            for (int i = 0; i < 4; i++) {
//                int newRow = DIR[i][0] + row;
//                int newCol = DIR[i][1] + col;
//                if (check(newRow, newCol, N, M) && !check[newRow][newCol] && matrix[newRow][newCol] != 0) {
//                    check[newRow][newCol] = true;
//                    queue.add(new int[]{newRow, newCol, num + 1});
//                }
//            }
//        }
//    }

    private static boolean check(int newRow, int newCol, int N) {
        return newRow >= 0 && newRow < N && newCol >= 0 && newCol < N;
    }
}