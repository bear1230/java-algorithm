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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            recur(0,0,0,i);
        }

        System.out.println(answer);
    }

    private static void recur(int s, int cur, int sum, int cnt) {

        if (cur == cnt) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        for (int i = s; i < N; i++) {
            recur(i + 1, cur + 1, sum+arr[i], cnt);
        }
    }
}
