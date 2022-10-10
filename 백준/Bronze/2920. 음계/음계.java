import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int interval = Integer.parseInt(split[0]) - Integer.parseInt(split[1]);
        String result = "";
        for (int i = 1; i < 7; i++) {
            if (Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]) != interval) {
                result = "mixed";
                break;
            }
        }
        if (result.equals("")) {
            if (interval > 0) System.out.println("descending");
            else if (interval < 0) System.out.println("ascending");
        }
        else System.out.println(result);
    }
}