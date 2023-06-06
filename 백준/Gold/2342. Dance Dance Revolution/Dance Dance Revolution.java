import java.io.*;
import java.util.*;

public class Main {
    public static int[][][] matrix;
    public static List<Integer> list = new ArrayList<>();
    public static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            list.add(num);
        }
        size = list.size();
        matrix = new int[size][5][5];
        int ddr = ddr(0, 0, 0);
        System.out.println(ddr);
    }

    private static int ddr(int index, int left, int right) {
        if (index == size) return 0;
        if (matrix[index][left][right] != 0) return matrix[index][left][right];
        Integer next = list.get(index);
        int leftDistance = distance(left, next);
        int rightDistance = distance(right, next);
        return matrix[index][left][right] = Math.min(
                ddr(index + 1, next, right) + leftDistance,
                ddr(index + 1, left, next) + rightDistance
        );
    }

    private static int distance(int current, Integer next) {
        if (current == 0) return 2;
        else if (current == next) return 1;
        else if (Math.abs(next - current) == 2) return 4;
        else return 3;
    }
}