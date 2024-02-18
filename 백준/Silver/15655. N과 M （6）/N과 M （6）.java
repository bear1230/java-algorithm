

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 자연수 중에서 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 */
public class Main {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recur(0, 0);
        System.out.println(sb);
    }

    private static void recur(int s, int cur) {
        if (cur == M) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;

        }
        for (int i = s; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            answer[cur] = arr[i];
            recur(i+1,cur + 1);
            visited[i] = false;
        }
    }
}
