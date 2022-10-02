import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        int next = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int i = 0; i < next; i++) {
            set.add(st.nextToken());
        }
        next = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < next; i++) {
            if (set.contains(st.nextToken())) list.add("1");
            else list.add("0");
        }
        String join = String.join(" ", list);
        System.out.println(join);
    }
}