import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = -1000000;
		int min = 1000000;
		
		int t = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		for (int i = 0; i < t; ++i) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			min = Math.min(min, a);
			}			
		System.out.printf("%d %d",min, max);
	}
}