import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i == 0) arr[i] = 0;
            else arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }
//        String str = br.readLine();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int section = section(start - 1, end, arr);
            sb.append(section).append("\n");
        }
        System.out.println(sb);
    }

    private static int section(int start, int end, int[] arr) {
        return arr[end] - arr[start];
//        String[] split = str.split(" ");
////        StringTokenizer st = new StringTokenizer(str);
//        int sum = 0;
//        for (int i = start; i < end; i++) {
////        for (int i = 0; i < end; i++) {
////            if (i < start) st.nextToken();
////            else sum += Integer.parseInt(st.nextToken());
//            sum += Integer.parseInt(split[i]);
//        }
//        return sum;
    }
}