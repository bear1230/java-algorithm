import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덧셈2, 뺄셈1, 곱셈1, 나눗셈1
 *
 *
 * */
public class Main {
    static int N;
    static int[] arr;
    static int[] sign;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sign = new int[4];

        st = new StringTokenizer(br.readLine());
        // 덧샘 뺄셈 곱셈 나눗셈
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        recur(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recur(int cur, int sum) {
        if (cur == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (sign[i] > 0) {
                sign[i]--;
                switch (i) {
                    case 0:
                        recur(cur + 1, sum  + arr[cur] );
                        break;
                    case 1:
                        recur(cur + 1, sum - arr[cur]);
                        break;
                    case 2:
                        recur(cur + 1, sum * arr[cur]);
                        break;
                    case 3:
                        recur(cur + 1, sum / arr[cur] );
                        break;
                }
                sign[i]++;
            }

        }

    }
}
