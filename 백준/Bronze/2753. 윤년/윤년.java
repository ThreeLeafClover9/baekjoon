import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int a = scan.nextInt();
    	int result = 0;
    	if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
    		result = 1;
		}
    	System.out.println(result);
    	scan.close();    	
	}
}