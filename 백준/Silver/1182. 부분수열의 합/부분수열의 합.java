import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, 0);
        System.out.println(answer);

    }

    private static void recur(int cur, int cnt, int sum) {
        if (cur == N) {
            if (sum == S && cnt != 0) {
                answer++;
            }
            return;
        }
        recur(cur + 1, cnt + 1, sum + arr[cur]);
        recur(cur + 1, cnt, sum);
    }
}
