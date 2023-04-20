import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = logic(num);
        System.out.println(result);
    }

    private static int logic(int num) {
        int[] list = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i <= 2) list[i] = i;
            else list[i] = (list[i - 1] + list[i - 2]) % 10007;
        }
        return list[num];
    }
}