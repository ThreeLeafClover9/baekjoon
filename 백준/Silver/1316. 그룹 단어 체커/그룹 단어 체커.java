import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;
        Integer next = Integer.valueOf(br.readLine());
        for (int i = 0; i < next; i++) {
            String str = br.readLine();
            String result = "";
            String s = "";
            for (int j = 0; j < str.length(); j++) {
                String st = str.charAt(j) + "";
                if (result.contains(st) && !st.equals(s)) {
                    num--;
                    break;
                }
                s = st;
                result += st;
            }
            num++;
        }
        System.out.println(num);
    }
}