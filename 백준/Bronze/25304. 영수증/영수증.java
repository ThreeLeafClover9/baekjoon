import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = scanner.nextInt();
        int next = scanner.nextInt();
        for (int i = 0; i < next; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            budget -= a * b;
        }
        String str = budget == 0 ? "Yes" : "No";
        System.out.println(str);
    }
}