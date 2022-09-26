import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[42];
		int count = 0;
		
		for (int i = 0; i < 10; ++i) {
			int t = Integer.parseInt(br.readLine());
			nums[t % 42] += 1;			
		}
		for (int i = 0; i < 42; ++i) {
			if (nums[i] != 0 ) {
				count += 1;
			}
		}
		System.out.println(count);
	}
		
}