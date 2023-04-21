import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] array = new int[M][N];
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                String str = br.readLine();
                String[] split = str.split(" ");
                array[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            }
            sb.append(logic(M, N, array, new LinkedList<>())).append("\n");
        }
        System.out.println(sb);
    }

    private static int logic(int M, int N, int[][] array, Queue<int[]> queue) {
        int num = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            dir(poll, array, M, N);
            num++;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    num += logic(M, N, array, queue);
                }
            }
        }
        return num;
    }

    private static void dir(int[] poll, int[][] array, int M, int N) {
        array[poll[0]][poll[1]] = 0;
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < DIR.length; i++) {
            int x = poll[0] + DIR[i][0];
            int y = poll[1] + DIR[i][1];
            if (x >= 0 && x < M && y >= 0 && y < N && array[x][y] == 1) {
                dir(new int[]{x, y}, array, M, N);
            }
        }
    }
}