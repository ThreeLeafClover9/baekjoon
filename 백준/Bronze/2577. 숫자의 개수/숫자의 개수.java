import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		int[] nums = new int[10];
		
		for (int i = 0; i < 3; ++i) {
			int t = Integer.parseInt(br.readLine());
			num *= t; 
			}
		while (num/1 != 0) {
			nums[num % 10] += 1;			
			num = num / 10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(nums[i]);
		}
	}
		
}