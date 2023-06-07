import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] matrix = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            matrix[i][0] = x;
            matrix[i][1] = y;
        }
        double min = min(matrix, n);
        System.out.println(min);
    }

    private static double min(double[][] matrix, int n) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(Arrays::compare);
        weight(matrix, queue, n);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        double result = 0;
        int count = 0;
        while (count < n - 1) {
            double[] poll = queue.poll();
            double len = poll[0];
            int a = (int) poll[1];
            int b = (int) poll[2];
            if (union(a, b, parent)) {
                result += len;
                count++;
            }
        }
        return result;
    }

    private static void weight(double[][] matrix, PriorityQueue<double[]> queue, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double x = matrix[j][0] - matrix[i][0];
                double y = matrix[j][1] - matrix[i][1];
                double len = Math.sqrt(x * x + y * y);
                queue.add(new double[]{len, i, j});
            }
        }
    }

    private static boolean union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    private static int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        else return find(parent[a], parent);
    }
}