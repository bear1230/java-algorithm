
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cur = 0;
        recur(cur, 0);
        System.out.println(sb);

    }

    private static void recur(int cur, int start) {
        if (cur == M) {
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            answer[cur] = arr[i];
            recur(cur + 1, i + 1);
        }
    }
}
