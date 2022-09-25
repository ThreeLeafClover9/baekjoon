import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int x = scan.nextInt();
    	int y = scan.nextInt();
    	if (y - 45 >= 0) {
    		y -= 45;
		} else {
			y += 15;
			if(x - 1 < 0) {
				x += 23;
			} else {
				x -= 1;
			}
		}
    	System.out.printf("%d %d", x, y);
    	scan.close();    	
	}
}