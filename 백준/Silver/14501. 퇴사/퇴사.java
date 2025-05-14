import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기간 T, 금액 P
public class Main {
    static int N;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        arr = new int[N][2];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 소요기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        recur(0, 0);
        System.out.println(max);
    }

    private static void recur(int cur, int cnt) {
        if (cur > N) {
            return;
        }

        if (cur == N) {
            max = Math.max(max, cnt);
            return;
        }

        recur(cur + arr[cur][0], cnt + arr[cur][1]);
        recur(cur + 1, cnt);
    }
}
