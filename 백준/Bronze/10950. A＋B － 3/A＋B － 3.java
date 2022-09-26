import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int a = scan.nextInt();
    	int[] ints = new int[a*2];
    	for (int i = 0;i < a*2; i += 2) {
    		int x = scan.nextInt();
    		ints[i] = x;
    		x = scan.nextInt();
    		ints[i+1] = x;    		
    	}
    	for (int i = 0;i < a*2; i += 2) {
    		System.out.println(ints[i]+ints[i+1]);    		
    	}
    	scan.close();    	
	}
}