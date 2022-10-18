import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int tmp = 0;
        while (tmp < num) {
            tmp += 1;
            int logic = logic(tmp);
            if (logic == num) {
                System.out.println(tmp);
                break;
            }
        }
        if (tmp == num) System.out.println(0);
    }

    static int logic(int num) {
        int tmp = num;
        while (num != 0) {
            tmp += num % 10;
            num /= 10;
        }
        return tmp;
    }
}