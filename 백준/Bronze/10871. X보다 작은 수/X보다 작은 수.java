import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str1 = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		
		for (int i = 0; i < str2.length; ++i) {
			if (Integer.parseInt(str1[1]) > Integer.parseInt(str2[i])) {
				bw.write(str2[i]+" ");
			}
		}
		
		bw.flush();		
	}
}