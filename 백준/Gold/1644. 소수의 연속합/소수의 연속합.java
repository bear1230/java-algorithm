import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        int sum = 0;
        int s = 0;
        int e = 0;
        int count = 0;

        while (true) {
            if (sum >= N) {
                sum -= list.get(s);
                s++;
            } else if (e == list.size()) {
                break;
            } else {
                sum += list.get(e);
                e++;
            }
            if (N == sum) {
                count++;
            }
        }
        System.out.println(count);

    }
}
