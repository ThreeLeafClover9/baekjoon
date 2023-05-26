import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int bytonic = bytonic(arr, N);
        System.out.println(bytonic);
    }

    private static int bytonic(int[] arr, int N) {
        int result = 0;
        int[] RIGHT = new int[N];
        int[] LEFT = new int[N];
        right(arr, RIGHT, N);
        left(arr, LEFT, N);
        for (int i = 0; i < N; i++) {
            result = Math.max(result, RIGHT[i] + LEFT[i] - 1);
        }
        return result;
    }

    private static void right(int[] arr, int[] RIGHT, int N) {
        for (int i = 0; i < N; i++) {
            RIGHT[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && RIGHT[i] <= RIGHT[j]) {
                    RIGHT[i] = RIGHT[j] + 1;
                }
            }
        }
    }

    private static void left(int[] arr, int[] LEFT, int N) {
        for (int i = N - 1; i >= 0; i--) {
            LEFT[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && LEFT[i] <= LEFT[j]) {
                    LEFT[i] = LEFT[j] + 1;
                }
            }
        }
    }
}