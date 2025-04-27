import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

/**
 * -1 -2 -6 -100 3
 * <p>
 * 완탐 -> 값 하나씩 최대값 구하기
 * N의 범위가 작다 -> 시간초과 안남! ( N!개의 경우의수)
 */
public class Main {
    static boolean[] visited;
    static int[] answer, arr;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(max);
    }

    private static void recur(int depth) {
        if (depth == N) {
            max = Math.max(cal(), max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recur(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int cal() {
        int sum = 0;
        for (int i = 1; i < N; i++)
            sum += Math.abs(answer[i - 1] - answer[i]);
        return sum;
    }
}


