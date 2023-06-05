import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int round = (int) Math.round(N * 15 / 100.0);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        double sum = 0;
        for (int i = round; i < N - round; i++) {
            sum += arr[i];
        }
        int result = (int) Math.round(sum / (N - round * 2));
        System.out.println(result);
    }
}