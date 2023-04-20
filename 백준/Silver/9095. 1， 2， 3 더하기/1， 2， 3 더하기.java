import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(logic(0, target, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int logic(int num, int targe, int result) {
        if (num == targe) return result + 1;
        int[] NUM = {3, 2, 1};
        for (int i = 0; i < 3; i++) {
            int tmp = num + NUM[i];
            if (tmp <= targe) result = logic(tmp, targe, result);
        }
        return result;
    }
}