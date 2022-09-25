import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.nextLine();
    	String[] inputs = input.split(" ");
    	int a = Integer.parseInt(inputs[0]);
    	int b = Integer.parseInt(inputs[1]);
    	System.out.println(a+b);
;	}
}