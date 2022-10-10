import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);
        int next = st.countTokens();
        int sum = 0;
        for (int i = 0; i < next; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * num;
        }

        System.out.println(sum % 10);
    }
}