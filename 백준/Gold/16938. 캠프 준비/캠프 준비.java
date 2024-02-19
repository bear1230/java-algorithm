
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N L R X
 * 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
 * 또, 다양한 문제를 경험해보기 위해 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
 * -> 각 문제 max, min 계산 필요
 */
public class Main {
    static int N, L, R, X;
    static int[] arr;
    static boolean[] visited; //문제 방문 확인
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //sum-> 난이도의 합,s -> 현재 문제의 인덱스, depth
        recur(0, 0, 0);
        System.out.println(answer);

    }

    private static void recur(int sum, int start, int cur) {
        if (cur >= 2) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            }
            if (L <= sum && sum <= R && max - min >= X) {
                answer++;
            }
          
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(sum + arr[i], i + 1, cur + 1);
                visited[i] = false;
            }
        }
    }
}
