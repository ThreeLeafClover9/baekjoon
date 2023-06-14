import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] line = new long[4][2];
        int index = 0;
        while (index < 4) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    line[index][j] = Integer.parseInt(st.nextToken());
                }
                index++;
            }
        }
        int cross = cross(line);
        System.out.println(cross);
        br.close();
    }

    private static int cross(long[][] line) {
        if (ccw(line[0], line[1], line[2]) * ccw(line[0], line[1], line[3]) == 0
                && ccw(line[2], line[3], line[0]) * ccw(line[2], line[3], line[1]) == 0) {
            long x1 = Math.min(line[0][0], line[1][0]);
            long x2 = Math.max(line[0][0], line[1][0]);
            long x3 = Math.min(line[2][0], line[3][0]);
            long x4 = Math.max(line[2][0], line[3][0]);
            long y1 = Math.min(line[0][1], line[1][1]);
            long y2 = Math.max(line[0][1], line[1][1]);
            long y3 = Math.min(line[2][1], line[3][1]);
            long y4 = Math.max(line[2][1], line[3][1]);
            if (x3 <= x2 && x1 <= x4 && y3 <= y2 && y1 <= y4) return 1;
            else return 0;
        } else if (ccw(line[0], line[1], line[2]) * ccw(line[0], line[1], line[3]) <= 0
                && ccw(line[2], line[3], line[0]) * ccw(line[2], line[3], line[1]) <= 0) {
            return 1;
        }
        return 0;
    }

    private static long ccw(long[] p1, long[] p2, long[] p3) {
        long x1 = p1[0];
        long y1 = p1[1];
        long x2 = p2[0];
        long y2 = p2[1];
        long x3 = p3[0];
        long y3 = p3[1];
        long result = x1 * y2 + x2 * y3 + x3 * y1 - (x2 * y1 + x3 * y2 + x1 * y3);
        return result > 0 ? 1 : result < 0 ? -1 : 0;
    }
}