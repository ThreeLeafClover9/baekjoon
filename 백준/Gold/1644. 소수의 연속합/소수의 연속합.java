import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int continual = continual(N);
        System.out.println(continual);
    }

    private static int continual(int N) {
        int count = 0;
        List<Integer> list = primeNumber(N);
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            int sum = 0;
            int index = i;
            while (index >= 0) {
                sum += list.get(index);
                if (sum == N) count++;
                if (sum > N) break;
                index--;
            }
        }
        return count;
    }

    private static List<Integer> primeNumber(int N) {
        boolean[] prime = new boolean[N + 1];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) prime[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) list.add(i);
        }
        return list;
    }
}

