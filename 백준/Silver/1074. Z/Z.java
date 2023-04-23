import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int R = Integer.parseInt(split[1]);
        int C = Integer.parseInt(split[2]);
        int len = (int) Math.pow(2, N);
        long num = logic(0, 0, len, 0, R, C);
        System.out.println(num);
    }

    private static long logic(int row, int col, int len, long count, int R, int C) {
        int rowLen = 0;
        int colLen = 0;
        while (len != 1) {
            len /= 2;
            long pow = (long) Math.pow(len, 2);
            if (R < rowLen + len) {
                if (C < colLen + len) {
                } else {
                    col += len;
                    count += pow;
                    colLen += len;
                }
            } else {
                if (C < colLen + len) {
                    row += len;
                    count += pow * 2;
                    rowLen += len;
                } else {
                    row += len;
                    col += len;
                    count += pow * 3;
                    rowLen += len;
                    colLen += len;
                }
            }
        }
        return count;
    }
}