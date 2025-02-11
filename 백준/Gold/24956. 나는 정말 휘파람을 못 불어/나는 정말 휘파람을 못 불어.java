import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;

/**
 * 접근 방법 : 완탐 O(n^3)으로 시간초과 발생
 * H를 기준으로 앞에있는 W와 뒤에있는E를 찾기
 */

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        long[] arr = new long[3];
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'W') {
                arr[0]++;
                arr[0] %= MOD;
            } else if (s.charAt(i) == 'H') {
                arr[1] += arr[0];
                arr[1] %= MOD;
            } else if (s.charAt(i) == 'E') {
                sum += arr[2];
                arr[2] *= 2;
                arr[2] += arr[1];
                arr[2] %= MOD;

            }
            sum %= MOD;
            
        }
        System.out.println(sum);

    }
}
