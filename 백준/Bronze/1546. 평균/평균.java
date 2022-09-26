import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		double max = 0;
		String t = br.readLine();;
		double[] dou = new double[c];
		double result = 0;
		StringTokenizer st = new StringTokenizer(t);
		
		for (int i = 0; i < c; ++i) {
			max = Math.max(Integer.parseInt(st.nextToken()), max);
		}
		String[] str = t.split(" ");
		for (int i = 0; i < c; ++i) {
			dou[i] = Integer.parseInt(str[i])/max*100;
			}
		for (int i = 0; i < c; ++i) {
			result += dou[i];
		}
		
		System.out.println(result/c);
		
	}
		
}