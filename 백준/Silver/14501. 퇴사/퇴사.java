import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); 
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        System.out.println(answer);
    }

    static void recur(int cur, int pay) {
        if(cur >= N) {
            answer = Math.max(pay, answer);
            return;
        }

        if(cur + arr[cur][0] <= N) { 
            recur(cur + arr[cur][0], pay + arr[cur][1]);
        } else { 
            recur(cur + arr[cur][0], pay);
        }
        
        recur(cur + 1, pay);
    }
}
