import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String str = "==";
        if (a > b) str = ">";
        else if (a < b) str = "<";
        System.out.println(str);
    }
}