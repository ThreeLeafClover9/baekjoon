import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num =  0;
		int count = 0;
		
		for (int i = 1; i <= 9; ++i) {
			int t = Integer.parseInt(br.readLine());
            
			if (t > num) {
				num = t;
				count = i;
			}
		}
		System.out.println(num);
		System.out.println(count);
	}
}