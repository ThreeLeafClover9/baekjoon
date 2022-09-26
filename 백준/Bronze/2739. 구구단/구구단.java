import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        for (int i = 1; i <= 9; i++) {
            String format = String.format("%d * %d = %d", next, i, next * i);
            System.out.println(format);
        }
    }
}