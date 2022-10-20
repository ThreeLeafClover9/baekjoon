import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            int[][] array = new int[x + 1][y];
            for (int j = 0; j < y; j++) {
                array[0][j] = j + 1;
            }
            for (int j = 1; j <= x; j++) {
                array[j][0] = 1;
                for (int k = 1; k < y; k++) {
                    array[j][k] = array[j][k - 1] + array[j - 1][k];
                }
            }
            bw.write(array[x][y - 1] + "\n");
        }
        bw.close();
    }
}