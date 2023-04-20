import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = logic(num, new int[num + 1]);
        System.out.println(result);
    }

    private static int logic(int num, int[] list) {
        if (list[num] != 0) return list[num];
        if (num <= 2) return num;
        return list[num] = (list[num] + logic(num - 1, list) + logic(num - 2, list)) % 10007;
    }
}