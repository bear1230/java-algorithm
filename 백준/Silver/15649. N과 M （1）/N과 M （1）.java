import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N과 M : 백트레킹
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *
 * */

public class Main {
    static int N, M;
    static int cur;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        cur = 0;
        recur(cur);
    }

    private static void recur(int cur) {
        if (cur == M) {  
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[cur] = i+1;
            recur(cur + 1);
            visited[i] = false;
        }

    }
}
