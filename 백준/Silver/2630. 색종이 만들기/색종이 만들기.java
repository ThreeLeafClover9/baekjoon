import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String[][] matrix = new String[next][next];
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            matrix[i] = str.split(" ");
        }
        System.out.println(logic(new int[]{0, 0}, new int[]{next, next}, matrix, "0"));
        System.out.println(logic(new int[]{0, 0}, new int[]{next, next}, matrix, "1"));
    }

    private static int logic(int[] start, int[] end, String[][] matrix, String value) {
        int count = 0;
        boolean check = true;
        if (start[0] == end[0] || start[1] == end[1]) return 0;
        outer:
        for (int i = start[0]; i < end[0]; i++) {
            for (int j = start[1]; j < end[1]; j++) {
                if (!matrix[i][j].equals(value)) {
                    check = false;
                    count += logic(new int[]{start[0], start[1]}, new int[]{(end[0] + start[0]) / 2, (end[1] + start[1]) / 2}, matrix, value);
                    count += logic(new int[]{start[0], (end[1] + start[1]) / 2}, new int[]{(end[0] + start[0]) / 2, end[1]}, matrix, value);
                    count += logic(new int[]{(end[0] + start[0]) / 2, start[1]}, new int[]{end[0], (end[1] + start[1]) / 2}, matrix, value);
                    if (end[0] - start[0] == 1) {
                        count += logic(end, end, matrix, value);
                    } else count += logic(new int[]{(end[0] + start[0]) / 2, (end[1] + start[1]) / 2}, new int[]{end[0], end[1]}, matrix, value);
                    break outer;
                }
            }
        }
        if (check) count++;
        return count;
    }
}