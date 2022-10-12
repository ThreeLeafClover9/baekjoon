import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        while (!(str = br.readLine()).equals("0")) {
            if (str.equals("")) continue;
            else if (str.length() == 1) bw.write("yes" + "\n");
            else {
                boolean check = true;
                for (int i = 0; i < str.length() / 2; i++) {
                    if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                        bw.write("no" + "\n");
                        check = false;
                        break;
                    }
                }
                if (check) bw.write("yes" + "\n");
            }
        }
        bw.close();
    }
}