import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 n과 k가 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법 중에서 k번째로 오는 식
 * 완전탐색 -> 1 2 3 더하는 모든 경우의수 구해보기
 * *
 * 탐색할 수 있는 숫자 정의 후
 * K번째를 찾게되면 종료
 */

public class Main {
    static int N, K;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        recur(0, 0);
        if (K > count) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

    private static void recur(int sum, int depth) {
        if (sum > N) {
            return;
        }
        if (sum == N) {
            count++;
            if (count == K) {
                for (int i = 0; i < depth - 1; i++) {
                    sb.append(arr[i]).append("+");
                }
                sb.append(arr[depth - 1]);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            arr[depth] = i;
            recur(sum + i, depth + 1);
        }
    }
}
