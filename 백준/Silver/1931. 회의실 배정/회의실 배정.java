import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int next = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        int num = logic(list);
        System.out.println(num);
    }

    private static int logic(List<int[]> list) {
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        int num = 0;
        int end = 0;
        for (int[] ints : list) {
            if (ints[0] >= end) {
                num++;
                end = ints[1];
            }
        }
        return num;
    }
}