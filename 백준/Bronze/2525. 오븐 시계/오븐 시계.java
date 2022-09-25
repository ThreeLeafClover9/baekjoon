import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int a = scan.nextInt();
    	int b = scan.nextInt();
    	int c = scan.nextInt();
    	b += c;
    	for (;b>= 60;b-=60) {
			a += 1;
			if (a >= 24) {
				a -= 24;
			}
		}
    	System.out.printf("%d %d", a, b);
    	scan.close();    	
	}
}