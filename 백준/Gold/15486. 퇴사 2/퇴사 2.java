import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;// 날짜, 수익
    static int[] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        //마지막 날(N일)에 만약  T=1 이라면 일을 할 수 있기 때문에 DP배열을 1~N+1까지 받아야 한다
        dp = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (i + arr[i][0] > N) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = Math.max(dp[i + 1], arr[i][1] + dp[i + arr[i][0]]);
        }

        answer = dp[0];
        bw.write(answer+ "");
        bw.flush();
        bw.close();
        br.close();
    }

    //시간초과
    private static int recur(int cur) {
        if (cur > N) {
            return Integer.MIN_VALUE;
        }

        if (cur == N) {
            return 0;
        }

        if (dp[cur] != -1) {
            return dp[cur];
        }

        //        recur(cur + arr[cur][0]) + arr[cur][1];
        //        recur(cur + 1);
        dp[cur] = Math.max(recur(cur + arr[cur][0]) + arr[cur][1], recur(cur + 1));

        return dp[cur];
    }
}