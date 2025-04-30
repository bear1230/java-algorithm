import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * N을 1 2 3의 합으로 나타내는 방법 중 K번째로 오는 식
 * */

public class Main {
    static int N, K;
    static int[] arr;
    static int answer;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        recur(0, 0);
        if(K>count){
            System.out.println(-1);
        }
        System.out.println(sb);
    }

    private static void recur(int cur, int sum) {
        if (sum > N) return;
        if (sum == N) {
            count++;
            if (count == K) {
                for (int i = 0; i < cur-1; i++) {
                    sb.append(arr[i]).append("+");
                }
                sb.append(arr[cur-1]);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr[cur] = i;
            recur(cur + 1, sum + i);
        }
    }
}
