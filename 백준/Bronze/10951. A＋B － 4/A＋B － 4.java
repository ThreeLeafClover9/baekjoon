import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;
		int n1, n2;


		
		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());		
			sb.append(n1+n2+"\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();


	}
}