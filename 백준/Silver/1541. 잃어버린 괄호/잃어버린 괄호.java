import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");
        int bracket = bracket(split);
        System.out.println(bracket);
    }

    private static int bracket(String[] split) {
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String[] str = split[i].split("\\+");
            for (String s : str) {
                if (i == 0) result += Integer.parseInt(s);
                else result -= Integer.parseInt(s);
            }
        }
        return result;
    }
}