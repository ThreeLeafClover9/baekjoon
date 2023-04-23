import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int next = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] split = str.split(" ");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        logic(array);
    }

    private static void logic(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int i = 0;
        for (int num : array) {
            if (map.containsKey(num)) continue;
            map.put(num, i++);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}