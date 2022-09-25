import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int sum = A * B;
        while (B > 0) {
            System.out.println(A * (B % 10));
            B /= 10;
        }
        System.out.println(sum);
    }
}