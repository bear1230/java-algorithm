import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n=10
 * 1 = 2^0
 * 2 = 2^1
 * 3 = 2^0
 * 4 = 2^2
 * 5 = 2^0
 * 6 = 2^1
 * 7 = 2^0
 * 8 = 2^3
 * 9 = 2^0
 * 10 = 2^1
 * 0 1 0 2 0 1 0 3 0 1
 * n=10
 * 2 = 2^1
 * 4 = 2^2
 * 6 = 2^1
 * 8 = 2^3
 * 10 = 2^1
 * 해당 수들만 2로 나누어짐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        System.out.println(solution(b) - solution(a - 1));
    }

    private static long solution(long n) {
        long sum = 0;
        long i = 1;
        long answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                sum = n / 2;
            } else {
                sum = n / 2 + 1;
            }
            answer += sum * i;
            n -= sum;
            i *= 2;
        }
        return answer;

    }
}
