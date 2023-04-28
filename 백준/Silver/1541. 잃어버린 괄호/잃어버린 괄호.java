import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String num = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') {
                list.add(Integer.parseInt(num));
                num = "";
            } else if (c == '-') {
                list.add(Integer.parseInt(num));
                num = "-";
            } else num += c;
        }
        list.add(Integer.parseInt(num));
        int bracket = bracket(list);
        System.out.println(bracket);
    }

    private static int bracket(List<Integer> list) {
        int result = 0;
        boolean plus = true;
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            if (num < 0) plus = false;
            if (plus) result += Math.abs(num);
            else result -= Math.abs(num);
        }
        return result;
    }
}