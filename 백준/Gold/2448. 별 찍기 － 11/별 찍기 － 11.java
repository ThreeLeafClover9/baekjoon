import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int log = (int) (Math.log(N / 3) / Math.log(2));
        List<String> list = new ArrayList<>();
        list.add("  *  ");
        list.add(" * * ");
        list.add("*****");
        star(0, log, list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void star(int index, int n, List<String> list) {
        if (index == n) return;
        String repeat = " ".repeat((int) (3 * Math.pow(2, index)));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            String newStr1 = repeat + str + repeat;
            String newStr2 = str + " " + str;
            list.remove(i);
            list.add(i, newStr1);
            list.add(newStr2);
        }
        star(index + 1, n, list);
    }
}