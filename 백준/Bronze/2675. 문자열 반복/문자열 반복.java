import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = Integer.parseInt(br.readLine());
        for (int i = 0; i < next; i++) {
            String[] split = br.readLine().split(" ");
            int repeat = Integer.parseInt(split[0]);
            String str = split[1];
            String result = "";
            for (int j = 0; j < str.length(); j++) {
                String s = String.valueOf(str.charAt(j));
                result += s.repeat(repeat);
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}