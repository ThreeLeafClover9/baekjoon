import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String[] split = next.split(" ");
        String result = "";
        int k = 1;
        for (int i = 0; i < split.length; i++) {
            if (i >= 5) k = 8;
            else if (i >= 2) k = 2;
            result += k - Integer.valueOf(split[i]) + " ";
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}